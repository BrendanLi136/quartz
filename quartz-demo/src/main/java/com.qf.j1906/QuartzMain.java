package com.qf.j1906;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Author: Brendan Li
 * @description test
 * @Date: 2019/12/02/23:12
 */
public class QuartzMain {
    public static void main(String[] args) throws SchedulerException {
//        1.创建Job对象,你要做什么事
        JobDetail job = JobBuilder.newJob(QuartzDemo.class).build();

        /**
         * 1.简单的trigger触发时间
         * 2.cron表达式
         */
//        2.创建Trigger对象,在什么时间做?
//        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.repeatSecondlyForever()).build();

        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")).build();

//        3.创建Scheduler对象,在什么时间做什么事?
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(job,trigger);

        scheduler.start();

    }
}
