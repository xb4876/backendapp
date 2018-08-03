package com.renwu.backendapp.wallet.entity;

import com.renwu.backendapp.core.model.BaseEntity;

import java.util.Date;

/**
 * 问题反馈实体类
 * @author xb4876
 */
public class Problem extends BaseEntity {

    private Integer id;// 主键，自增
    private int problem_type; //反馈类型，1产品建议；2程序错误；3其他
    private String problem_content;  // '反馈意见'
    private String problem_contact; // '联系方式'
    private int feedback_state;// '反馈状态，0未反馈；1反馈'
    private String feedback_result; // '反馈结果'

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getProblem_type() {
        return problem_type;
    }

    public void setProblem_type(int problem_type) {
        this.problem_type = problem_type;
    }

    public String getProblem_content() {
        return problem_content;
    }

    public void setProblem_content(String problem_content) {
        this.problem_content = problem_content;
    }

    public String getProblem_contact() {
        return problem_contact;
    }

    public void setProblem_contact(String problem_contact) {
        this.problem_contact = problem_contact;
    }

    public int getFeedback_state() {
        return feedback_state;
    }

    public void setFeedback_state(int feedback_state) {
        this.feedback_state = feedback_state;
    }

    public String getFeedback_result() {
        return feedback_result;
    }

    public void setFeedback_result(String feedback_result) {
        this.feedback_result = feedback_result;
    }
}
