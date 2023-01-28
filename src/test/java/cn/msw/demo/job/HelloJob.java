package cn.msw.demo.job;

import org.quartz.*;

import java.util.Date;

//@DisallowConcurrentExecution
public class HelloJob implements Job {
    /**
     * 执行任务
     * @param context 任务上下文
     * @throws JobExecutionException 任务执行异常
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // 获取任务详情
        JobDetail jobDetail = context.getJobDetail();

        // 获取任务名称
        String jobName = jobDetail.getKey().getName();

        // 获取任务组名
        String jobGroup = jobDetail.getKey().getGroup();
        // 打印
        System.out.println("jobName: " + jobName + ", jobGroup: " + jobGroup);
        System.out.println(new Date());

        // 睡眠3s
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
