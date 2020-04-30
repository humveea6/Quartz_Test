package org.example;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloJob implements Job {

    private String msg;

    private float floatData;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current extime is :"+sf.format(date));

        JobKey key = jobExecutionContext.getJobDetail().getKey();
        System.out.println("Key name and group are :" + key.getName() + ":" + key.getGroup());
        System.out.println(msg);
        System.out.println(floatData);
        System.out.println("Hello world!");
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public float getFloatData() {
        return floatData;
    }

    public void setFloatData(float floatData) {
        this.floatData = floatData;
    }
}
