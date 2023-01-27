package cn.msw.demo.job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class Main {

    public static void main(String[] args) throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
                .build();


        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("job1", "group1")
                .build();

        scheduler.scheduleJob(jobDetail, cronTrigger);
        scheduler.start();
    }
}
