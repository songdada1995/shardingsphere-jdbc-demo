package com.example.config.thread;

import com.example.exception.BasicException;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
public class CustomRejectedExecutionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        if (!executor.isShutdown()) {
            try {
                log.info("start get queue");
                executor.getQueue().put(r);
                log.info("end get queue");
            } catch (InterruptedException e) {
                log.error(BasicException.exceptionTrace(e));
                Thread.currentThread().interrupt();
            }
        }
    }

}
