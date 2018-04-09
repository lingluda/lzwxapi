package com.maiyue.weixin.service.impl;

import com.maiyue.weixin.bean.ManagerTaskInfo;
import com.maiyue.weixin.constant.Constant;
import com.maiyue.weixin.service.ManagerTaskInfoService;
import com.maiyue.weixin.service.QuartzService;
import org.apache.commons.lang3.StringUtils;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by huang on 2018/01/16.
 */
//@Service("quartzService")
public class QuartzServiceImpl {

//    private static final Logger log = LoggerFactory.getLogger(QuartzService.class);
//    
//    @Resource(name = "scheduler")
//    private Scheduler scheduler;
//    
//    @Resource(name = "managerTaskInfoService")
//    private ManagerTaskInfoService managerTaskInfoService;
//
//    
//    @Override
//    public void refreshTaskInfo() {
//        //List<ManagerTaskInfo> taskInfoList = managerTaskInfoService.findAll(new Map<String,Object>());
//        //dealTaskInfo(taskInfoList);
//    }
//
//    @Override
//    public void addTaskInfo(ManagerTaskInfo managerTaskInfo) {
//        try {
//            CronTrigger trigger = this.getCronTrigger(managerTaskInfo);
//            //说明任务还没有添加到quartz中
//            if(trigger == null){
//                if(Constant.QUARTZ_TASK_INFO_ENABLE.equals(managerTaskInfo.getStatus())){
//                    //创建JobDetail（数据库中cls_name是完整的CLASS路径，动态的把任务注入到JobDetail中）
//                    JobDetail jobDetail = JobBuilder.newJob((Class<? extends Job>) Class.forName(managerTaskInfo.getClsName()))
//                            .withIdentity(managerTaskInfo.getTaskName(), managerTaskInfo.getTaskGroup()).build();
//                    //表达式调度构建器
//                    CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(managerTaskInfo.getExpress());
//
//                    trigger = TriggerBuilder.newTrigger()
//                            .withIdentity(managerTaskInfo.getTaskName(), managerTaskInfo.getTaskGroup())
//                            .withSchedule(scheduleBuilder).build();
//
//                    scheduler.scheduleJob(jobDetail, trigger);
//
//                    if(log.isDebugEnabled()) {
//                        log.debug("addTaskInfo:"+managerTaskInfo.getTaskName(),",The task add success ", managerTaskInfo);
//                    }
//                }
//            }else{
//                if(log.isDebugEnabled()) {
//                    log.debug("addTaskInfo:"+managerTaskInfo.getTaskName()+",The task has already existed", managerTaskInfo);
//                }
//            }
//        } catch (SchedulerException e){
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    
//    @Override
//    public void updateTaskInfo(ManagerTaskInfo managerTaskInfo) {
//        if(managerTaskInfo != null && managerTaskInfo.getStatus() != null){
//            //已存在任务,更新任务
//            //停止任务
//            try {
//                CronTrigger trigger = this.getCronTrigger(managerTaskInfo);
//                if(trigger != null){
//                    if (Constant.QUARTZ_TASK_INFO_DISABLE.equals(managerTaskInfo.getStatus())) {
//                        //删除任务
//                        this.deleteTaskInfo(managerTaskInfo);
//                    } else if (Constant.QUARTZ_TASK_INFO_ENABLE.equals(managerTaskInfo.getStatus())) {
//                        String searchCron = managerTaskInfo.getExpress();
//                        String currentCron = trigger.getCronExpression();
//                        //说明该任务有变化，需要更新quartz中的对应的记录
//                        if (!searchCron.equals(currentCron)) {
//                            //表达式调度构建器
//                            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(searchCron);
//
//                            //按新的cronExpression表达式重新构建trigger
//                            trigger = trigger.getTriggerBuilder().withIdentity(trigger.getKey())
//                                    .withSchedule(scheduleBuilder).build();
//                            //按新的trigger重新设置job执行
//                            scheduler.rescheduleJob(trigger.getKey(), trigger);
//
//                            if(log.isDebugEnabled()) {
//                                log.debug("updateTaskInfo:"+managerTaskInfo.getTaskName()+",The task update success", managerTaskInfo);
//                            }
//                        }
//                    }
//                }
//
//            } catch (SchedulerException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Override
//    public void deleteTaskInfo(ManagerTaskInfo managerTaskInfo) {
//        //已存在任务,更新任务
//        //停止任务
//        try {
//            CronTrigger trigger = this.getCronTrigger(managerTaskInfo);
//            if (trigger != null) {
//                //删除任务
//                JobKey jobKey = JobKey.jobKey(managerTaskInfo.getTaskName(), managerTaskInfo.getTaskGroup());
//                scheduler.deleteJob(jobKey);
//
//                if (log.isDebugEnabled()) {
//                    log.debug("deleteTaskInfo:" + managerTaskInfo.getTaskName() + ",The task delete success", managerTaskInfo);
//                }
//            } else {
//                if (log.isDebugEnabled()) {
//                    log.debug("deleteTaskInfo:" + managerTaskInfo.getTaskName() + ",The task does not exist ", managerTaskInfo);
//                }
//            }
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public CronTrigger getCronTrigger(ManagerTaskInfo managerTaskInfo) {
//        if(managerTaskInfo != null && StringUtils.isNotBlank(managerTaskInfo.getTaskName())
//                && StringUtils.isNotBlank(managerTaskInfo.getTaskGroup())) {
//            try {
//                TriggerKey triggerKey = TriggerKey.triggerKey(managerTaskInfo.getTaskName(), managerTaskInfo.getTaskGroup());
//                CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
//                return trigger;
//            } catch (SchedulerException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }
//
//    private void dealTaskInfo(List<ManagerTaskInfo> taskInfoList) {
//        if (taskInfoList != null && taskInfoList.size() > 0) {
//            taskInfoList.stream().filter((taskInfo) -> (taskInfo != null && taskInfo.getStatus() != null))
//                    .forEach((taskInfo -> {
//                        CronTrigger trigger = this.getCronTrigger(taskInfo);
//                        //说明任务还没有添加到quartz中
//                        if (trigger == null) {
//                            this.addTaskInfo(taskInfo);
//                        } else {
//                            this.updateTaskInfo(taskInfo);
//                        }
//                    }));
//        }
//    }
    
}
