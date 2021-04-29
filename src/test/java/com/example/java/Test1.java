package com.example.java;

import com.example.utils.DateUtils;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        List<String> dateStrList = new ArrayList<>();
        dateStrList.add("2020-04-01 05:15:20");
        dateStrList.add("2021-02-02 05:15:20");
        dateStrList.add("2021-03-12 09:15:20");
        dateStrList.add("2021-10-12 09:15:20");
        dateStrList.add("2021-04-01 15:15:20");

        List<String> betweenMinAndMaxDateStrList = DateUtils.getBetweenMinAndMaxMonthStrList(dateStrList, "yyyy-MM-dd HH:mm:ss", "yyyyMM");
        if (CollectionUtils.isNotEmpty(betweenMinAndMaxDateStrList)) {
            for (String s : betweenMinAndMaxDateStrList) {
                System.out.println(s);
            }
        }
    }
}
