package com.qf.j1906;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: Brendan Li
 * @description Scheduled定时任务
 * @Date: 2019/12/02/22:43
 */
@Slf4j
@Component
public class ScheduledDemo {

    /**
     * @Scheduled: 设置定时任务
     * cron属性:cron表达式
     */
    @Scheduled(cron = "0/2 * * * * ?")
    public void scheduledMethod(){
      log.info("定时器触发:"+new Date());
    }
}
