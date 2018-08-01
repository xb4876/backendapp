package com.renwu.backendapp.wallet.entity;

import com.renwu.backendapp.core.model.BaseEntity;

import java.util.Date;

/**
 * 单页面信息
 * @author xb4876
 */
public class SinglePage extends BaseEntity {
    private Integer id;// 主键，自增
    private String module_name;//所属模块，（协议；服务；隐私条款）
    private String module;//模块名称
    private String title;// 标题
    private String detail;// 内容

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public String getModule_name() {
        return module_name;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
