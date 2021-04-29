package com.example.config.sharding;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * t_account表标准分片算法
 */
@Slf4j
public class TAccountPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Integer> {

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Integer> preciseShardingValue) {
        Integer siteId = preciseShardingValue.getValue();
        String tableSuffix = String.format("%02d", siteId);
        for (String tableName : availableTargetNames) {
            if (tableName.endsWith(tableSuffix)) {
                return tableName;
            }
        }
        throw new IllegalArgumentException("未找到匹配的数据表");
    }


}
