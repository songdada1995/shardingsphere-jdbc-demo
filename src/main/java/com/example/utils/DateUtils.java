package com.example.utils;

import com.example.exception.BasicException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
public class DateUtils {

    /**
     * 获取指定日期间的所有日期字符串
     * @param dBeginStr
     * @param dEndStr
     * @param parsePattern
     * @param formatPattern
     * @return
     */
    public static List<String> getBetweenDateStrList(String dBeginStr, String dEndStr, String parsePattern, String formatPattern) {
        List<String> dateList = new ArrayList();

        try {
            dateList.add(dBeginStr);
            SimpleDateFormat format1 = new SimpleDateFormat(parsePattern);
            SimpleDateFormat format2 = new SimpleDateFormat(formatPattern);
            Date dBegin = format1.parse(dBeginStr);
            Date dEnd = format1.parse(dEndStr);

            Calendar calBegin = Calendar.getInstance();
            // 使用给定的 Date 设置此 Calendar 的时间
            calBegin.setTime(dBegin);
            Calendar calEnd = Calendar.getInstance();
            // 使用给定的 Date 设置此 Calendar 的时间
            calEnd.setTime(dEnd);
            // 测试此日期是否在指定日期之后
            while (dEnd.after(calBegin.getTime())) {
                // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
                calBegin.add(Calendar.DAY_OF_MONTH, 1);
                dateList.add(format2.format(calBegin.getTime()));
            }
        } catch (ParseException e) {
            log.error(BasicException.exceptionTrace(e));
        }

        return dateList;
    }

    /**
     * 获取指定月份期间的所有月份字符串
     * @param dBeginStr
     * @param dEndStr
     * @param parsePattern
     * @param formatPattern
     * @return
     */
    public static List<String> getBetweenMonthStrList(String dBeginStr, String dEndStr, String parsePattern, String formatPattern) {
        List<String> dateList = new ArrayList();

        try {
            dateList.add(dBeginStr);
            SimpleDateFormat format1 = new SimpleDateFormat(parsePattern);
            SimpleDateFormat format2 = new SimpleDateFormat(formatPattern);
            Date dBegin = format1.parse(dBeginStr);
            Date dEnd = format1.parse(dEndStr);

            Calendar calBegin = Calendar.getInstance();
            // 使用给定的 Date 设置此 Calendar 的时间
            calBegin.setTime(dBegin);
            Calendar calEnd = Calendar.getInstance();
            // 使用给定的 Date 设置此 Calendar 的时间
            calEnd.setTime(dEnd);
            // 测试此日期是否在指定日期之后
            while (dEnd.after(calBegin.getTime())) {
                // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
                calBegin.add(Calendar.MONTH, 1);
                dateList.add(format2.format(calBegin.getTime()));
            }
        } catch (ParseException e) {
            log.error(BasicException.exceptionTrace(e));
        }

        return dateList;
    }

    /**
     * 获取日期字符串中的最大最小日期，并格式化返回map
     * @param dateStrList
     * @param parsePattern
     * @param formatPattern
     * @return
     */
    public static Map<String, String> getMinAndMaxDateMap(List<String> dateStrList, String parsePattern, String formatPattern) {
        if (CollectionUtils.isEmpty(dateStrList)) {
            return null;
        }

        try {
            List<Long> dateTimeList = new ArrayList<>(dateStrList.size());
            SimpleDateFormat format1 = new SimpleDateFormat(parsePattern);
            for (String dateStr : dateStrList) {
                dateTimeList.add(format1.parse(dateStr).getTime());
            }

            Collections.sort(dateTimeList);
            SimpleDateFormat format2 = new SimpleDateFormat(formatPattern);
            Map<String, String> resultMap = new HashMap<>();
            resultMap.put("minDate", format2.format(new Date(dateTimeList.get(0))));
            resultMap.put("maxDate", format2.format(new Date(dateTimeList.get(dateTimeList.size() - 1))));
            return resultMap;

        } catch (ParseException e) {
            log.error(BasicException.exceptionTrace(e));
            return null;
        }
    }

    /**
     * 获取日期字符串中的最大最小日期之前的所有日期字符串
     * @param dateStrList
     * @param parsePattern
     * @param formatPattern
     * @return
     */
    public static List<String> getBetweenMinAndMaxDateStrList(List<String> dateStrList, String parsePattern, String formatPattern) {
        if (CollectionUtils.isEmpty(dateStrList)) {
            return null;
        }

        try {
            List<Long> dateTimeList = new ArrayList<>(dateStrList.size());
            SimpleDateFormat format1 = new SimpleDateFormat(parsePattern);
            for (String dateStr : dateStrList) {
                dateTimeList.add(format1.parse(dateStr).getTime());
            }

            Collections.sort(dateTimeList);
            SimpleDateFormat format2 = new SimpleDateFormat(formatPattern);
            return getBetweenDateStrList(
                    format2.format(new Date(dateTimeList.get(0))),
                    format2.format(new Date(dateTimeList.get(dateTimeList.size() - 1))),
                    formatPattern,
                    formatPattern);

        } catch (ParseException e) {
            log.error(BasicException.exceptionTrace(e));
            return null;
        }
    }

    /**
     * 获取日期字符串中的最大最小日期之前的所有月份字符串
     * @param dateStrList
     * @param parsePattern
     * @param formatPattern
     * @return
     */
    public static List<String> getBetweenMinAndMaxMonthStrList(List<String> dateStrList, String parsePattern, String formatPattern) {
        if (CollectionUtils.isEmpty(dateStrList)) {
            return null;
        }

        try {
            List<Long> dateTimeList = new ArrayList<>(dateStrList.size());
            SimpleDateFormat format1 = new SimpleDateFormat(parsePattern);
            for (String dateStr : dateStrList) {
                dateTimeList.add(format1.parse(dateStr).getTime());
            }

            Collections.sort(dateTimeList);
            SimpleDateFormat format2 = new SimpleDateFormat(formatPattern);
            return getBetweenMonthStrList(
                    format2.format(new Date(dateTimeList.get(0))),
                    format2.format(new Date(dateTimeList.get(dateTimeList.size() - 1))),
                    formatPattern,
                    formatPattern);

        } catch (ParseException e) {
            log.error(BasicException.exceptionTrace(e));
            return null;
        }
    }

}
