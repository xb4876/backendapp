package com.renwu.backendapp.core.model;

/**
 * 错误信息处理
 * 
 * @author xb4876
 *
 */
public class Message {

	private int code;
	private String message;
	private Object content;

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public Object getContent() {
		return content;
	}

	public Message() {

	}

	public Message(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public Message(int code, String message, Object content) {
		this.code = code;
		this.message = message;
		this.content = content;
	}

	public void setMsg(int code, String message) {
		this.code = code;
		this.message = message;
		this.content = "no content";
	}

	public void setMsg(int code, String message, Object content) {
		this.code = code;
		this.message = message;
		this.content = content;
	}

}
