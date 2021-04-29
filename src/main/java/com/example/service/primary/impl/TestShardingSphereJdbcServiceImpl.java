package com.example.service.primary.impl;

import com.example.dao.primary.TAccountMapper;
import com.example.dao.primary.TOrderMapper;
import com.example.model.primary.TAccount;
import com.example.model.primary.TOrder;
import com.example.model.primary.query.TAccountQuery;
import com.example.model.primary.query.TOrderQuery;
import com.example.service.primary.ITestShardingSphereJdbcService;
import com.example.utils.Responses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class TestShardingSphereJdbcServiceImpl implements ITestShardingSphereJdbcService {

    @Resource
    private TOrderMapper tOrderMapper;
    @Resource
    private TAccountMapper tAccountMapper;

    @Override
    @Transactional
    public Responses insertAccount(TAccount account) {
        int i = tAccountMapper.insertOne(account);
        log.info("新增" + i + "条t_account表记录");
        return Responses.newInstance().succeed("执行成功！");
    }

    @Override
    @Transactional
    public Responses insertAccountList(List<TAccount> accountList) {
        int i = tAccountMapper.insertList(accountList);
        log.info("新增" + i + "条t_account表记录");
        return Responses.newInstance().succeed("执行成功！");
    }

    @Override
    public Responses selectAccount(TAccountQuery query) {
        Assert.notNull(query.getSiteId(), "站点不能为空！");
        return null;
    }

    @Override
    public Responses selectOrder(TOrderQuery query) {
        Assert.notNull(query.getOrderDate(), "订单日期不能为空！");
        List<TOrder> tOrders = tOrderMapper.findByQuery(query);
        return Responses.newInstance().succeed(tOrders);
    }

    @Override
    @Transactional
    public Responses insertOrder(TOrder order) {
        int i = tOrderMapper.insertOne(order);
        log.info("新增" + i + "条t_order表记录");
        return Responses.newInstance().succeed("执行成功！");
    }


}
