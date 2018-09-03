package com.renwu.backendapp.wallet.mapper;
import com.renwu.backendapp.wallet.entity.Question;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 帮助中心接口
 * @author xb4876
 */
@Component //使用Component代替Mapper
public interface QuestionMapper {

    Question selectById(Integer id);

    List<Question> findList(@Param("entity")Question entity);

    int update(Question entity);

    int save(Question entity);

    void delete(String id);

    Question findOne(int id);

    List<Question> getQuestion3(@Param("entity")Question entity);

    /**
     * 累计反馈数量
     * @return
     */
    int allHelpCount();
}
