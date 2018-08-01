package com.renwu.backendapp.wallet.entity;

import java.util.Date;

/**
 *  应用使用情况记录，分为装机和日活的用户使用行为记录，用于统计分析装机量和日活跃用户量
 *  @author ChenZhang
 */
public class AppUse {
    private long id; //主键，自增
    private String dev_no; //设备号
    private String dev_model; //设备型号
    private Date create_date; //创建时间
    private int use_type; // 使用类型（1装机；2日活）

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDev_no() {
        return dev_no;
    }

    public void setDev_no(String dev_no) {
        this.dev_no = dev_no;
    }

    public String getDev_model() {
        return dev_model;
    }

    public void setDev_model(String dev_model) {
        this.dev_model = dev_model;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public int getUse_type() {
        return use_type;
    }

    public void setUse_type(int use_type) {
        this.use_type = use_type;
    }
}
