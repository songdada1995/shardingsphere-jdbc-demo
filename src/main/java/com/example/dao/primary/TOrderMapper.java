package com.example.dao.primary;

import com.example.core.Mapper;
import com.example.model.primary.TOrder;
import com.example.model.primary.query.TOrderQuery;

import java.util.List;

public interface TOrderMapper extends Mapper<TOrder> {

    int insertOne(TOrder order);

    List<TOrder> findByQuery(TOrderQuery query);

}