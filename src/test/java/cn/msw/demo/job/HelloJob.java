package cn.msw.demo.job;

import org.quartz.*;

//@DisallowConcurrentExecution
public class HelloJob implements Job {
    /**
     * 执行任务
     * @param context 任务上下文
     */
    @Override
    public void execute(JobExecutionContext context) {
        // 获取任务详情
        JobDetail jobDetail = context.getJobDetail();
        Trigger trigger = context.getTrigger();

        JobDataMap jobDataMap = trigger.getJobDataMap();
        String triggerJobDataMap = jobDataMap.getString("name");

        // 获取任务名称
        String jobName = jobDetail.getKey().getName();

        // 获取任务组名
        String jobGroup = jobDetail.getKey().getGroup();

        // 会以trigger的JobDataMap为准
        String name = String.valueOf(context.getMergedJobDataMap().get("name"));

        String jobDataMapName = String.valueOf(jobDetail.getJobDataMap().get("name"));

        // 打印
        System.out.println("jobName: " + jobName + ", jobGroup: " + jobGroup +
                ", triggerJobDataMap: " + triggerJobDataMap +
                ", jobDataMapName: " + jobDataMapName +
                ", merge: " + name);

        // 睡眠3s
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
