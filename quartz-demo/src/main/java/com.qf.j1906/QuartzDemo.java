package com.qf.j1906;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;


/**
 * @Author: Brendan Li
 * @description 定时任务类
 * @Date: 2019/12/02/23:01
 */
public class QuartzDemo implements Job {


    /*任务触发时所调用的函数*/
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Execute..."+new Date());

    }
}
