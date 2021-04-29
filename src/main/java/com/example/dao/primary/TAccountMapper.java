package com.example.dao.primary;

import com.example.core.Mapper;
import com.example.model.primary.TAccount;

public interface TAccountMapper extends Mapper<TAccount> {

    int insertOne(TAccount account);

}