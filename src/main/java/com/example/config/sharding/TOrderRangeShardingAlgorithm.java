//package com.example.config.sharding;
//
//import com.example.utils.DateUtils;
//import com.google.common.collect.Range;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
//import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Date;
//import java.util.List;
//
///**
// * Date分片算法
// */
//@Slf4j
//public class TOrderRangeShardingAlgorithm implements RangeShardingAlgorithm<Date> {
//
//    @Override
//    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Date> rangeShardingValue) {
//        List<String> list = new ArrayList<>();
//        Range<Date> valueRange = rangeShardingValue.getValueRange();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
//        String lowerSuffix = sdf.format(valueRange.lowerEndpoint());
//        String upperSuffix = sdf.format(valueRange.upperEndpoint());
//
//        List<String> suffixList;
//        // 小于最小分表，则查询原始表
//        if (Integer.parseInt(lowerSuffix) < 202104) {
//            list.add("t_order");
//            suffixList = DateUtils.getBetweenMonthStrList("202104", upperSuffix, "yyyyMM", "yyyyMM");
//        } else {
//            suffixList = DateUtils.getBetweenMonthStrList(lowerSuffix, upperSuffix, "yyyyMM", "yyyyMM");
//        }
//
//        for (String tableName : availableTargetNames) {
//            if (containTableName(suffixList, tableName)) {
//                list.add(tableName);
//            }
//        }
//        log.info("match tableNames-----------------------" + list.toString());
//        return list;
//    }
//
//    private boolean containTableName(List<String> suffixList, String tableName) {
//        boolean flag = false;
//        for (String s : suffixList) {
//            if (tableName.endsWith(s)) {
//                flag = true;
//                break;
//            }
//        }
//        return flag;
//    }
//
//}
