package com.example.model.primary.query;

import com.example.model.core.PageQuery;

import java.util.List;

public class TAccountQuery extends PageQuery {

    private String accountName;

    private List<String> accountNameList;

    private Integer siteId;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public List<String> getAccountNameList() {
        return getObjList(accountName, accountNameList);
    }

    public void setAccountNameList(List<String> accountNameList) {
        this.accountNameList = accountNameList;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }
}
