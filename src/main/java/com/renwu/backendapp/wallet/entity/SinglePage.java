package com.renwu.backendapp.wallet.entity;

import com.renwu.backendapp.core.model.BaseEntity;

import java.util.Date;

/**
 * 单页面信息
 * @author xb4876
 */
public class SinglePage extends BaseEntity {
    private Integer id;// 主键，自增
    private String dict_name;//类型名称
    private String dict_type;//类型标识符，（例如app中的关于我们的信息）
    private String title;// 标题
    private String detail;// 内容

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDict_name() {
        return dict_name;
    }

    public void setDict_name(String dict_name) {
        this.dict_name = dict_name;
    }

    public String getDict_type() {
        return dict_type;
    }

    public void setDict_type(String dict_type) {
        this.dict_type = dict_type;
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
