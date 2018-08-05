package com.renwu.backendapp.wallet.entity;

/**
 *  应用使用情况记录，分为装机和日活的用户使用行为记录，用于统计分析装机量和日活跃用户量
 *  用于运营分析
 *  @author ChenZhang
 */
public class AppUse {
    private int activeCount; //活跃量
    private String dateTime; //设备号
    private String dev_model; //设备型号
    private int devCount; // 设备型号装机量

    public int getActiveCount() {
        return activeCount;
    }

    public void setActiveCount(int activeCount) {
        this.activeCount = activeCount;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDev_model() {
        return dev_model;
    }

    public void setDev_model(String dev_model) {
        this.dev_model = dev_model;
    }

    public int getDevCount() {
        return devCount;
    }

    public void setDevCount(int devCount) {
        this.devCount = devCount;
    }
}
