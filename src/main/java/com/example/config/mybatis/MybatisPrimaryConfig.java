package com.example.config.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.config.sharding.TAccountPreciseShardingAlgorithm;
import com.example.config.sharding.TOrderComplexKeysShardingAlgorithm;
import com.example.core.Mapper;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.shardingsphere.api.config.sharding.KeyGeneratorConfiguration;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.ComplexShardingStrategyConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.mapper.entity.Config;
import tk.mybatis.mapper.mapperhelper.MapperHelper;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@MapperScan(basePackages = MybatisPrimaryConfig.SCAN_PACKAGE, sqlSessionFactoryRef = MybatisPrimaryConfig.BEAN_SQL_SESSION_FACTORY_NAME)
public class MybatisPrimaryConfig {

    /* 多数据原配置 - 修改开始 */
    static final String SCAN_PACKAGE = "com.example.dao.primary";
    static final String MAPPER_LOCATION = "classpath*:mapper/primary/*.xml";
    static final String DATA_SOURCE_PROPERTIES_PREFIX = "spring.shardingsphere.datasource.primary";
    static final String BEAN_NAME_PREFIX = "primary";
    /* 多数据原配置 - 修改结束 */

    static final String BEAN_SQL_SESSION_FACTORY_NAME = BEAN_NAME_PREFIX + "SqlSessionFactory";
    static final String BEAN_DATA_SOURCE_NAME = BEAN_NAME_PREFIX + "DataSource";
    static final String BEAN_TRANSACTION_MANAGER_NAME = BEAN_NAME_PREFIX + "TransactionManager";
    static final String BEAN_SQL_SESSION_TEMPLATE_NAME = BEAN_NAME_PREFIX + "SqlSessionTemplate";
    static final String BEAN_MAPPER_HELPER_NAME = BEAN_NAME_PREFIX + "MapperHelper";

    static final String SHARDING_BEAN_DATA_SOURCE_NAME = BEAN_NAME_PREFIX + "ShardingDataSource";
    // 逻辑表，例如：order_01到order_12，则他们的逻辑表名为order
    static final String T_ACCOUNT_LOGIC_TABLE = "t_account";
    static final String T_ORDER_LOGIC_TABLE = "t_order";

    @Value("${spring.shardingsphere.rules.sharding.tables.t_account.table-strategy.standard.sharding-column}")
    private String T_ACCOUNT_SHARDING_COLUMN;
    @Value("${spring.shardingsphere.rules.sharding.tables.t_account.actual-data-nodes}")
    private String T_ACCOUNT_ACTUAL_DATA_NODES;
    @Value("${spring.shardingsphere.rules.sharding.tables.t_account.key-generate-strategy.column}")
    private String T_ACCOUNT_KEY_GENERATE_STRATEGY_COLUMN;
    @Value("${spring.shardingsphere.rules.sharding.tables.t_account.key-generate-strategy.key-generator-name}")
    private String T_ACCOUNT_KEY_GENERATE_STRATEGY_TYPE;

    @Value("${spring.shardingsphere.rules.sharding.tables.t_order.table-strategy.complex.sharding-column}")
    private String T_ORDER_SHARDING_COLUMN;
    @Value("${spring.shardingsphere.rules.sharding.tables.t_order.actual-data-nodes}")
    private String T_ORDER_ACTUAL_DATA_NODES;

    @Value("${spring.shardingsphere.rules.sharding.binding-tables}")
    private String SHARDING_BINDING_TABLES;
    @Value("${spring.shardingsphere.rules.sharding.defaultDataSourceName}")
    private String SHARDING_DEFAULT_DATA_SOURCE_NAME;
    @Value("${spring.shardingsphere.props.sql.show}")
    private String SHARDING_PROPS_SQL_SHOW;


    @Bean(name = BEAN_DATA_SOURCE_NAME)
    @ConfigurationProperties(prefix = DATA_SOURCE_PROPERTIES_PREFIX)
    public DruidDataSource dataSource() {
        return new DruidDataSource();
    }

    @Primary
    @Bean(name = SHARDING_BEAN_DATA_SOURCE_NAME)
    public DataSource shardingDataSource(@Qualifier(value = BEAN_DATA_SOURCE_NAME) DruidDataSource dataSource) throws SQLException {
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(tAccountTableRuleConfiguration());
        shardingRuleConfig.getTableRuleConfigs().add(tOrderTableRuleConfiguration());

        // 绑定表规则列表
        shardingRuleConfig.setBindingTableGroups(Arrays.asList(SHARDING_BINDING_TABLES.split(",")));
        // 未配置分片规则的表将通过默认数据源定位
        shardingRuleConfig.setDefaultDataSourceName(SHARDING_DEFAULT_DATA_SOURCE_NAME);

        Properties properties = new Properties();
        properties.setProperty("sql.show", SHARDING_PROPS_SQL_SHOW);

        return ShardingDataSourceFactory.createDataSource(createDataSourceMap(dataSource), shardingRuleConfig, properties);
    }

    /**
     * t_account 标准分片策略配置
     * @return
     */
    private TableRuleConfiguration tAccountTableRuleConfiguration() {
        TableRuleConfiguration tableRuleConfiguration = new TableRuleConfiguration(T_ACCOUNT_LOGIC_TABLE, T_ACCOUNT_ACTUAL_DATA_NODES);
        tableRuleConfiguration.setTableShardingStrategyConfig(new StandardShardingStrategyConfiguration(T_ACCOUNT_SHARDING_COLUMN, new TAccountPreciseShardingAlgorithm()));
        // 分布式序列策略，雪花ID
        Properties properties = new Properties();
        properties.setProperty("work.id", "1");
        tableRuleConfiguration.setKeyGeneratorConfig(new KeyGeneratorConfiguration(T_ACCOUNT_KEY_GENERATE_STRATEGY_TYPE, T_ACCOUNT_KEY_GENERATE_STRATEGY_COLUMN, properties));

        return tableRuleConfiguration;
    }

    /**
     * t_order 复合分片策略配置
     * @return
     */
    private TableRuleConfiguration tOrderTableRuleConfiguration() {
        TableRuleConfiguration tableRuleConfiguration = new TableRuleConfiguration(T_ORDER_LOGIC_TABLE, T_ORDER_ACTUAL_DATA_NODES);
        tableRuleConfiguration.setTableShardingStrategyConfig(new ComplexShardingStrategyConfiguration(T_ORDER_SHARDING_COLUMN,
                new TOrderComplexKeysShardingAlgorithm()));
        return tableRuleConfiguration;
    }

    private Map<String, DataSource> createDataSourceMap(DruidDataSource dataSource) {
        // key为数据源名称，后面分片算法取得就是这个，value为具体的数据源
        HashMap<String, DataSource> shardingDataSourceMap = new HashMap<>();
        shardingDataSourceMap.put(BEAN_NAME_PREFIX, dataSource);
        return shardingDataSourceMap;
    }


    @Primary
    @Bean(name = BEAN_TRANSACTION_MANAGER_NAME)
    public DataSourceTransactionManager transactionManager(@Qualifier(value = SHARDING_BEAN_DATA_SOURCE_NAME) DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean(name = BEAN_SQL_SESSION_FACTORY_NAME)
    public SqlSessionFactory sqlSessionFactory(
            @Qualifier(value = SHARDING_BEAN_DATA_SOURCE_NAME) DataSource dataSource
    ) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        //分页插件
        PageInterceptor pageInterceptor = new PageInterceptor();

        //更多详细配置见: https://pagehelper.github.io/docs/howtouse/
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");           //方言
        properties.setProperty("rowBoundsWithCount", "true");       //使用 RowBounds 分页会进行 count 查询
        properties.setProperty("reasonable", "true");               //pageNum<=0 时会查询第一页， pageNum>pages（超过总数时），会查询最后一页
        properties.setProperty("pageSizeZero", "true");             //如果 pageSize=0 或者 RowBounds.limit = 0 就会查询出全部的结果
        properties.setProperty("supportMethodsArguments", "true");  //支持通过 Mapper 接口参数来传递分页参数
        properties.setProperty("offsetAsPageNum", "true");          //将 RowBounds 中的 offset 参数当成 pageNum 使用

        pageInterceptor.setProperties(properties);

        //添加插件
        sessionFactory.setPlugins(new Interceptor[]{pageInterceptor});

        //设置mapper location
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MybatisPrimaryConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

    @Primary
    @Bean(name = BEAN_SQL_SESSION_TEMPLATE_NAME)
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier(value = BEAN_SQL_SESSION_FACTORY_NAME) SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * Mybatis 通用Mapper配置
     *
     * @param sqlSessionFactory
     * @return
     */
    @Bean(name = BEAN_MAPPER_HELPER_NAME)
    public MapperHelper mapperHelper(@Qualifier(value = BEAN_SQL_SESSION_FACTORY_NAME) SqlSessionFactory sqlSessionFactory) {
        MapperHelper mapperHelper = new MapperHelper();
        //特殊配置
        Config config = new Config();
        config.setNotEmpty(false);
        config.setIDENTITY("MYSQL");
        //更多详细配置: http://git.oschina.net/free/Mapper/blob/master/wiki/mapper3/2.Integration.md
        mapperHelper.setConfig(config);
        mapperHelper.registerMapper(Mapper.class);
        mapperHelper.processConfiguration(sqlSessionFactory.getConfiguration());
        return mapperHelper;
    }


}
