package com.example.config.sharding;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * 字符期间 yyyy-MM 期间分片算法
 *
 * @Author songbo
 * @Date 2021/4/8 16:13
 * @Version 1.0
 */
public class PeriodRangeShardingAlgorithm implements RangeShardingAlgorithm<String> {

    /**
     * 范围分片算法，用于BETWEEN
     *
     * @param collection
     * @param rangeShardingValue
     * @return
     */
    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<String> rangeShardingValue) {
        Range<String> valueRange = rangeShardingValue.getValueRange();
        Date right = null;
        Date left = null;
        // 如果有固定范围则取
        if (valueRange.hasLowerBound()) {
            String lowerEndpoint = valueRange.upperEndpoint();
            String yearMonth = lowerEndpoint.substring(0, 7);
            left = DateUtil.parse(yearMonth, "yyyy-MM");
        }
        if (valueRange.hasUpperBound()) {
            String upperEndpoint = valueRange.upperEndpoint();
            String yearMonth = upperEndpoint.substring(0, 7);
            right = DateUtil.parse(yearMonth, "yyyy-MM");
        }

        Range<Date> range;
        if (left == null && right != null) {
            range = Range.upTo(right, valueRange.upperBoundType());
        } else if (right == null && left != null) {
            range = Range.downTo(left, valueRange.lowerBoundType());
        } else {
            range = Range.range(left, valueRange.lowerBoundType(), right, valueRange.upperBoundType());
        }
        ArrayList<String> list = new ArrayList<>();
        for (String tableOriginName : collection) {
            // 表名是“table_202101”此种格式
            String tableTime = tableOriginName.split("_")[1];
            DateTime time = DateUtil.parse(tableTime, "yyyyMM");
            if (range.contains(time)) {
                list.add(tableOriginName);
            }
        }
        return list;

    }
}
