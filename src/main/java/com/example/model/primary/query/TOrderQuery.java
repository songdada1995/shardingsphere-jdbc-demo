package com.example.model.primary.query;

import com.example.model.core.PageQuery;

import java.util.List;

public class TOrderQuery extends PageQuery {

    private String orderNo;

    private List<String> orderNoList;

    private String orderDate;

    private String startDate;

    private String endDate;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public List<String> getOrderNoList() {
        return getObjList(orderNo, orderNoList);
    }

    public void setOrderNoList(List<String> orderNoList) {
        this.orderNoList = orderNoList;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStartDate() {
        if (orderDate != null) {
            return orderDate.split(",")[0] + " 00:00:00";
        }

        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        if (orderDate != null) {
            return orderDate.split(",")[1] + " 23:59:59";
        }

        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
