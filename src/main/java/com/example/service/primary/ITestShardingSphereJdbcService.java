package com.example.service.primary;

import com.example.model.primary.TAccount;
import com.example.model.primary.TOrder;
import com.example.model.primary.query.TAccountQuery;
import com.example.model.primary.query.TOrderQuery;
import com.example.utils.Responses;

import java.util.List;

public interface ITestShardingSphereJdbcService {
    
    Responses selectAccount(TAccountQuery query);

    Responses selectOrder(TOrderQuery query);

    Responses insertOrder(TOrder order);

    Responses insertAccount(TAccount account);

    Responses insertAccountList(List<TAccount> accountList);
}
