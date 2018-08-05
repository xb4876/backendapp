package com.renwu.backendapp.wallet.entity;

import com.renwu.backendapp.core.model.BaseEntity;

import java.util.Date;

/**
 *  APP应用版本信息
 * @author ChenZhang
 */
public class AppVersion extends BaseEntity {
    private int id; // 主键，自增
    private String version; //应用版本号码
    private String title; //标题名称
    private String note; //更新说明
    private String url; //Android安装包文件地址
    private String iosurl; //ios的下载页面地址
    private int is_new; //是否最新版本,0否；1是

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIosurl() {
        return iosurl;
    }

    public void setIosurl(String iosurl) {
        this.iosurl = iosurl;
    }

    public int getIs_new() {
        return is_new;
    }

    public void setIs_new(int is_new) {
        this.is_new = is_new;
    }
}
