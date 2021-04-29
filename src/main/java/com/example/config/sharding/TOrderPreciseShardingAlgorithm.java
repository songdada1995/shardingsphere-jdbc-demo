//package com.example.config.sharding;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
//import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
//
//import java.text.SimpleDateFormat;
//import java.util.Collection;
//import java.util.Date;
//
///**
// * 按订单日期进行分片
// */
//@Slf4j
//public class TOrderPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Date> {
//
//    @Override
//    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Date> preciseShardingValue) {
//        try {
//            Date date = preciseShardingValue.getValue();
//            Date boundaryDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2021-04-01 00:00:00");
//            if (date.compareTo(boundaryDate) < 0) {
//                return "t_order";
//            }
//
//            String suffix = new SimpleDateFormat("yyyyMM").format(date);
//            for (String tableName : availableTargetNames) {
//                if (tableName.endsWith(suffix)) {
//                    return tableName;
//                }
//            }
//            throw new IllegalArgumentException("未找到匹配的数据表");
//
//        } catch (Exception e) {
//            log.error("t_order表分片算法执行异常！", e);
//            throw new IllegalArgumentException("t_order表分片算法执行异常！");
//        }
//    }
//}
