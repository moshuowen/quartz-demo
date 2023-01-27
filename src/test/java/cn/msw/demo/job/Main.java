package cn.msw.demo.job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class Main {

    public static void main(String[] args) throws SchedulerException {
        // 创建调度器
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        // 创建触发器
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
                .build();
        // 创建任务
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("job1", "group1")
                .build();
        // 将任务和触发器注册到调度器中
        scheduler.scheduleJob(jobDetail, cronTrigger);
        // 启动调度器
        scheduler.start();
    }
}
