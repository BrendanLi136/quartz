package com.qf.j1906.config;

import com.qf.j1906.base.QuartzDemo;
import com.qf.j1906.root.MyAdaptableJobFactory;
import org.quartz.CronScheduleBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 * @Author: Brendan Li
 * @description Quartz配置类
 * @Date: 2019/12/02/23:42
 */
@Configuration
public class QuartzConfig {

    /**
     * 1.创建job对象
     */
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean(){
        JobDetailFactoryBean factory = new JobDetailFactoryBean();
        //关联自己的job类
        factory.setJobClass(QuartzDemo.class);
        return factory;
    }

    /**
     * 2.创建Trigger对象
     * 创建简单的trigger
     */
/*

    @Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
        //关联job对象
        factoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        //执行毫秒数
        factoryBean.setRepeatInterval(2000);
        //重复次数
        factoryBean.setRepeatCount(5);
        return factoryBean;
    }
*/

    //cron表达式
    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        cronTriggerFactoryBean.setCronExpression("0/2 * * * * ?");
        return cronTriggerFactoryBean;
    }

    /**
     * 3.创建Scheduler对象
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean, MyAdaptableJobFactory myAdaptableJobFactory){
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        factoryBean.setTriggers(cronTriggerFactoryBean.getObject());
        factoryBean.setJobFactory(myAdaptableJobFactory);
        return factoryBean;
    }



}
