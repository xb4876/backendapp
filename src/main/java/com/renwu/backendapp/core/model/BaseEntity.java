package com.renwu.backendapp.core.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import java.io.Serializable;
import java.util.Date;

/**
 * Entity支持类
 * @author xb4876
 * @version 2018-08-01
 */
public abstract class BaseEntity<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 开始页数
	 */
	protected int pageNum;
	/**
	 * 每页显示的数据条数
	 */
	protected int pageSize;

	/**
	 * 创建时间
	 */
	protected Date create_date;

	/**
	 * 更新时间
	 */
	protected Date update_date;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
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

	@Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

	
}
