package com.renwu.backendapp.wallet.entity;

import com.renwu.backendapp.core.model.BaseEntity;

import java.util.Date;

/**
 * 帮助信息
 * @author ChenZhang
 */
public class Question extends BaseEntity {
    private Integer id;// 主键，自增
    private String title;// 标题
    private String detail;// 内容
    private Integer orderby;// 显示顺序
    private Integer viewnum;// 阅读次数
    private Integer type;// 帮助分类

    public Integer getViewnum() {
        return viewnum;
    }

    public void setViewnum(Integer viewnum) {
        this.viewnum = viewnum;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getOrderby() {
        return orderby;
    }

    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
    }
}
