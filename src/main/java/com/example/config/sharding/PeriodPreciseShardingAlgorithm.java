package com.example.config.sharding;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * 字符期间 yyyy-MM 期间分片算法
 *
 * @Author songbo
 * @Date 2021/4/8 16:13
 * @Version 1.0
 */
public class PeriodPreciseShardingAlgorithm implements PreciseShardingAlgorithm<String> {

    /**
     * 精确分片算法，用于=和IN
     *
     * @param collection
     * @param preciseShardingValue
     * @return
     */
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<String> preciseShardingValue) {
        if (!preciseShardingValue.getValue().contains("-")) {
            throw new IllegalArgumentException();
        }
        String[] split = preciseShardingValue.getValue().split("-");
        String logicTableName = preciseShardingValue.getLogicTableName();
        // 定义表名
        String tableName = logicTableName + "_" + split[0] + split[1];
        for (String name : collection) {
            if (tableName.equals(name)) {
                return tableName;
            }
        }
        throw new IllegalArgumentException();
    }

}
