package com.example.service.retrytest;

import com.example.model.retrytest.SysUser;
import com.example.exception.BasicException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

public interface ITestRetryService {

    @Retryable(value = {RuntimeException.class, InterruptedException.class},
            maxAttempts = 5,
            backoff = @Backoff(delay = 2 * 1000, multiplier = 2, maxDelay = 5 * 60 * 1000))
    void insertOneByRuntimeException(SysUser user) throws RuntimeException, InterruptedException;

    @Retryable(value = {BasicException.class},
            maxAttempts = 3,
            backoff = @Backoff(delay = 3 * 1000, multiplier = 1.5, maxDelay = 5 * 60 * 1000))
    void insertOneByBasicException(SysUser user) throws BasicException;

}
