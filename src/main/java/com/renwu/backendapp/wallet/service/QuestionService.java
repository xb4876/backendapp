package com.renwu.backendapp.wallet.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.renwu.backendapp.wallet.entity.Question;
import com.renwu.backendapp.wallet.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionMapper mapper;

    /**
     * 获取问题列表
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    public PageInfo<Question> getQuestionList(Question entity) {
        List<Question> questions = mapper.findList(entity);
        PageInfo result = new PageInfo(questions);
        return result;
    }

    /**
     * 保存数据
     * @param entity
     * @return
     * @throws Exception
     */
    public int save(Question entity) throws Exception{
        int code = 0;
        entity.setUpdate_date(new Date());
        entity.setCreate_date(new Date());
        code = mapper.save(entity);
        return code;
    }

    /**
     * 删除数据
     * @param id
     */
    public void delete(String id) {
        mapper.delete(id);
    }

    public Question findOne(int id) {
        return mapper.findOne(id);
    }

    public int edit(Question entity) {
        int code = 0;
        entity.setUpdate_date(new Date());
        code = mapper.update(entity);
        return code;
    }

    /**
     * 获取帮助中心前三
     * @param question
     * @return
     */
    public List<Question> getQuestion3(Question question) {
        return mapper.getQuestion3(question);
    }
}
