package com.renwu.backendapp.wallet.entity;

import java.util.Date;

/**
 * 应用中的单信息记录，例如关于我们等信息
 * @author ChenZhang
 */
public class About {
    private int id;// 主键，自增
    private String dict_type; // 类型标识符，例如app中的关于我们的信息等
    private String detail; // 内容
    private Date create_date; //创建时间
    private Date update_date; //更新时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDict_type() {
        return dict_type;
    }

    public void setDict_type(String dict_type) {
        this.dict_type = dict_type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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
}
