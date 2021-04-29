package com.example.web;

import com.example.model.primary.TAccount;
import com.example.model.primary.TOrder;
import com.example.model.primary.query.TAccountQuery;
import com.example.model.primary.query.TOrderQuery;
import com.example.service.primary.ITestShardingSphereJdbcService;
import com.example.utils.Responses;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/testSharding")
public class TestShardingSphereJdbcController {

    @Resource
    private ITestShardingSphereJdbcService testShardingSphereJdbcService;

    @PostMapping(value = "/insertAccount")
    public Responses insertAccount(@RequestBody TAccount account) {
        return testShardingSphereJdbcService.insertAccount(account);
    }

    @GetMapping(value = "/selectAccount")
    public Responses selectAccount(TAccountQuery query) {
        return testShardingSphereJdbcService.selectAccount(query);
    }

    @GetMapping(value = "/selectOrder")
    public Responses selectOrder(TOrderQuery query) {
        return testShardingSphereJdbcService.selectOrder(query);
    }

    @PostMapping(value = "/insertOrder")
    public Responses insertOrder(@RequestBody TOrder order) {
        return testShardingSphereJdbcService.insertOrder(order);
    }

}
