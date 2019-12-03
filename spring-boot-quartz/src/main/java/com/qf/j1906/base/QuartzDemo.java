package com.qf.j1906.base;

import com.qf.j1906.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @Author: Brendan Li
 * @description
 * @Date: 2019/12/02/23:45
 */
@Slf4j
public class QuartzDemo implements Job {

    @Autowired
    private UserService userService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
      log.info("Execute..."+new Date());
      this.userService.add();
    }
}
