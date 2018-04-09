package com.maiyue.weixin.config;

import com.maiyue.weixin.quartz.MyJobFactory;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;


/**
 * Created by huang on 2018/01/12.
 */
/*
@Configuration
@AutoConfigureAfter({ DruidConfig.class })
*/
public class QuartzConfig {

	/*
    @Resource(name="druidDataSource")
    private DataSource druidDataSource;

    @Resource(name = "myJobFactory")
    private MyJobFactory myJobFactory;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setDataSource(druidDataSource);
        schedulerFactoryBean.setJobFactory(myJobFactory);
        schedulerFactoryBean.setQuartzProperties(quartzProperties());
        return schedulerFactoryBean;
    }

    /*
   * quartz初始化监听器
   */
	/*
    @Bean
    public QuartzInitializerListener executorListener() {
        return new QuartzInitializerListener();
    }
	*/
    /*
    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        //在quartz.properties中的属性被读取并注入后再初始化对象
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }
    */
    /*
     * 通过SchedulerFactoryBean获取Scheduler的实例
     */
    /*
    @Bean(name="myScheduler")
    public Scheduler scheduler() throws IOException {
        return schedulerFactoryBean().getScheduler();
    }
    */

    /**这是一组定时任务A   开始*/
    /*
    @Bean(name = "cronJob")
    public JobDetailFactoryBean createJob() {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(TestJob.class);
        factoryBean.setName(TestJob.class.getName());
        factoryBean.setGroup("testGroup");
        factoryBean.setDurability(true);
        return factoryBean;
    }
    */
    /*
    @Bean(name = "cronJobTrigger")
    public CronTriggerFactoryBean triggerFactoryBean(@Qualifier("cronJob") JobDetail jobDetail){
        CronTriggerFactoryBean stFactory = new CronTriggerFactoryBean();
        stFactory.setJobDetail(jobDetail);
        stFactory.setStartDelay(3000);
        stFactory.setName("testTrigger");
        stFactory.setGroup("testGroup");
        String express = "0/10 * * * * ?";
        stFactory.setCronExpression(express);
        return stFactory;
    }
    */
}
