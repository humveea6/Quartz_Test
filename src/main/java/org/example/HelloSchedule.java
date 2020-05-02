package org.example;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloSchedule {

    public static void main(String[] args) throws SchedulerException {

        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current time is :"+sf.format(date));

        JobDetail jobDetail = JobBuilder.
                newJob(HelloJob.class).
                usingJobData("msg","Hello my job!").
                usingJobData("floatData",3.14F).
                withIdentity("myjob","group1").
                build();


        CronTrigger trigger = (CronTrigger) TriggerBuilder
                .newTrigger()
                .withIdentity("mytrigger","group1")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("0/5 17 10 * * ? *")
                )
                .build();

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail,trigger);
    }
}
