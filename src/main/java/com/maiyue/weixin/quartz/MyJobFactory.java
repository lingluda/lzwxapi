package com.maiyue.weixin.quartz;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * Created by huang on 2018/01/12.
 */
//@Component("myJobFactory")
public class MyJobFactory extends AdaptableJobFactory {
	/*
    @Autowired
    private AutowireCapableBeanFactory capableBeanFactory;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object jobInstance = super.createJobInstance(bundle);
        //这一步解决不能spring注入bean的问题
        capableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
    */
}
