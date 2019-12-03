package com.qf.j1906.root;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: Brendan Li
 * @description
 * @Date: 2019/12/03/0:07
 */
@Component("myAdaptableJobFactory")
public class MyAdaptableJobFactory extends AdaptableJobFactory {

    /**
     * AutowireCapableBeanFactory 可以将一个对象添加到springIOC中,并完成对象的注入
     */
    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {

        Object object = super.createJobInstance(bundle);
        //将obj对象添加到spring IOC中,并完成注入
        autowireCapableBeanFactory.autowireBean(object);
        return object;
    }
}
