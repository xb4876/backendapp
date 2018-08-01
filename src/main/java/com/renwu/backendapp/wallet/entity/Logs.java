package com.renwu.backendapp.wallet.entity;

import java.util.Date;

/**
 *  系统操作日志，记录系统中所有的action的请求
 *  @author ChenZhang
 */
public class Logs {
    private long id; //主键，自增
    private Date create_date; //创建时间
    private String func_name; //功能名称
    private String func_url; //功能URL
    private String func_args;// 请求参数
    private String http_method;//提交方式，例：GET\\POST
    private String op_ip;//操作IP地址
    private long elapsed_time;//耗时（单位毫秒）

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getFunc_name() {
        return func_name;
    }

    public void setFunc_name(String func_name) {
        this.func_name = func_name;
    }

    public String getFunc_url() {
        return func_url;
    }

    public void setFunc_url(String func_url) {
        this.func_url = func_url;
    }

    public String getFunc_args() {
        return func_args;
    }

    public void setFunc_args(String func_args) {
        this.func_args = func_args;
    }

    public String getHttp_method() {
        return http_method;
    }

    public void setHttp_method(String http_method) {
        this.http_method = http_method;
    }

    public String getOp_ip() {
        return op_ip;
    }

    public void setOp_ip(String op_ip) {
        this.op_ip = op_ip;
    }

    public long getElapsed_time() {
        return elapsed_time;
    }

    public void setElapsed_time(long elapsed_time) {
        this.elapsed_time = elapsed_time;
    }
}
