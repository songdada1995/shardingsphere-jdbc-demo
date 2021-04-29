package com.example;

import com.example.model.primary.TAccount;
import com.example.model.primary.TOrder;
import com.example.model.primary.query.TOrderQuery;
import com.example.service.primary.ITestShardingSphereJdbcService;
import com.example.utils.Responses;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootTest
class ShardingSphereJdbcDemoApplicationTests {

    @Resource
    private ITestShardingSphereJdbcService testShardingSphereJdbcService;

    /**
     * 测试t_order表复合分片，插入单条数据
     */
    @Test
    void test1() {
        try {

            TOrder order = new TOrder();
            order.setOrderNo("PX2102090993416");
            order.setOrderQty(520);
            order.setOrderDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2021-02-28 09:31:05"));
            order.setCreateTime(new Date());
            order.setCreateBy("system");
            order.setCreateByUserId(0);
            testShardingSphereJdbcService.insertOrder(order);

//            TOrder order = new TOrder();
//            order.setOrderNo("PX2104020013946");
//            order.setOrderQty(66);
//            order.setOrderDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2021-04-05 15:33:21"));
//            order.setCreateTime(new Date());
//            order.setCreateBy("system");
//            order.setCreateByUserId(0);
//            testShardingSphereJdbcService.insertOrder(order);

//            TOrder order = new TOrder();
//            order.setOrderNo("NX2105010010539");
//            order.setOrderQty(78);
//            order.setOrderDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2021-05-16 09:01:22"));
//            order.setCreateTime(new Date());
//            order.setCreateBy("system");
//            order.setCreateByUserId(0);
//            testShardingSphereJdbcService.insertOrder(order);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试t_order表复合分片，条件查询
     */
    @Test
    void test2() {
        TOrderQuery query = new TOrderQuery();
        query.setOrderNo("PX2102090993416,PX2104020013946");
        query.setOrderDate("2021-02-01,2021-05-31");
        query.setOffset(0);
        query.setLimit(20);
        Responses responses = testShardingSphereJdbcService.selectOrder(query);
        System.out.println(responses.isSuccess());
        System.out.println(responses.getData());
    }

    /**
     * 测试t_account表，标准分片，插入单条数据
     */
    @Test
    void test3() {
        try {
            TAccount account = new TAccount();
            account.setAccountName("华南城");
            account.setAccountCode("huanancheng");
            account.setAreaId(2);
            account.setSiteId(1);
            account.setCreateTime(new Date());
            account.setCreateBy("system");
            account.setCreateByUserId(0);
            testShardingSphereJdbcService.insertAccount(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试t_account表，标准分片，插入多条数据
     */
    @Test
    void test4() {
        try {
            List<TAccount> accountList = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                TAccount account = new TAccount();
                account.setAccountName("华南城");
                account.setAccountCode("huanancheng");
                account.setAreaId(2);
                account.setSiteId(1);
                account.setCreateTime(new Date());
                account.setCreateBy("system");
                account.setCreateByUserId(0);
                accountList.add(account);
            }
            testShardingSphereJdbcService.insertAccountList(accountList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
