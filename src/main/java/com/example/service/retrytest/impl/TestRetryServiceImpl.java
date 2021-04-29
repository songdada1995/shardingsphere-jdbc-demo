package com.example.service.retrytest.impl;

import com.example.dao.retrytest.SysUserMapper;
import com.example.model.retrytest.SysUser;
import com.example.exception.BasicException;
import com.example.service.retrytest.ITestRetryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Recover;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@Service
public class TestRetryServiceImpl implements ITestRetryService {

    private static AtomicInteger count = new AtomicInteger(1);

    private static ReentrantLock lock = new ReentrantLock();

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    @Transactional
    public void insertOneByRuntimeException(SysUser user) throws RuntimeException, InterruptedException {
        log.info(Thread.currentThread().getName() + "进入insertOneByRuntimeException方法");
        try {
            lock.lock();

            log.info(Thread.currentThread().getName() + "：当前计数器为：" + count.get());
            Thread.sleep(5000);
            sysUserMapper.insert(user);
            count.incrementAndGet();
            throw new RuntimeException(Thread.currentThread().getName() + "：抛出RuntimeException");
        } catch (RuntimeException | InterruptedException e) {
            log.error(e.getMessage());
            throw e;
        } finally {
            lock.unlock();
        }
    }

    @Override
    @Transactional
    public void insertOneByBasicException(SysUser user) throws BasicException {
        try {
            lock.lock();

            log.info(Thread.currentThread().getName() + "：当前计数器为：" + count.get());
            while (true) {
                sysUserMapper.insert(user);
                count.incrementAndGet();
                throw BasicException.newInstance().error(Thread.currentThread().getName() + "：抛出BasicException", 500);
            }
        } catch (BasicException e) {
            log.error(e.getMessage());
            throw e;
        } finally {
            lock.unlock();
        }
    }

    @Recover
    public void recover(RuntimeException e) {
        log.warn("写入用户数据失败！回调记录RuntimeException", e.getMessage());
    }

    @Recover
    public void recover(BasicException e) {
        log.warn("写入用户数据失败！回调记录BasicException", e.getMessage());
    }
}
