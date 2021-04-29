package com.example.config.sharding;

import com.example.utils.DateUtils;
import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.util.*;

/**
 * t_order表复合分片算法
 */
public class TOrderComplexKeysShardingAlgorithm implements ComplexKeysShardingAlgorithm<String> {

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, ComplexKeysShardingValue<String> shardingValue) {

        Set<String> tableSet = new HashSet<>();

        Map<String, Collection<String>> shardingValuesMap = shardingValue.getColumnNameAndShardingValuesMap();
        if (shardingValuesMap.containsKey("order_no")) {
            Collection<String> orderNos = shardingValuesMap.get("order_no");
            for (String tableName : availableTargetNames) {
                for (String orderNo : orderNos) {
                    // 假定orderNo格式：NX2104010010539，XX+年月（4位）+订单类型（2位）+站点（3位）+随机4位
                    String suffix = orderNo.substring(2, 6);
                    // 202104以前的数据全部查询t_order表
                    if (Integer.parseInt(suffix) < 2104) {
                        tableSet.add("t_order");
                    } else {
                        if (tableName.endsWith(suffix)) {
                            tableSet.add(tableName);
                        }
                    }
                }
            }
        }

        Map<String, Range<String>> rangeValuesMap = shardingValue.getColumnNameAndRangeValuesMap();
        if (rangeValuesMap.containsKey("order_date")) {
            Range<String> valueRange = rangeValuesMap.get("order_date");
            String lowerSuffix = valueRange.lowerEndpoint().substring(0, 7).replace("-", "");
            String upperSuffix = valueRange.upperEndpoint().substring(0, 7).replace("-", "");

            List<String> suffixList;
            // 小于最小分表，则查询原始表
            if (Integer.parseInt(lowerSuffix) < 202104) {
                tableSet.add("t_order");
                suffixList = DateUtils.getBetweenMonthStrList("202104", upperSuffix, "yyyyMM", "yyyyMM");
            } else {
                suffixList = DateUtils.getBetweenMonthStrList(lowerSuffix, upperSuffix, "yyyyMM", "yyyyMM");
            }

            for (String tableName : availableTargetNames) {
                if (containTableName(suffixList, tableName)) {
                    tableSet.add(tableName);
                }
            }
        }

        return tableSet;
    }

    private boolean containTableName(List<String> suffixList, String tableName) {
        boolean flag = false;
        for (String s : suffixList) {
            if (tableName.endsWith(s)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

}
