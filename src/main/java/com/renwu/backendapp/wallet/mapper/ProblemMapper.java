package com.renwu.backendapp.wallet.mapper;

import com.renwu.backendapp.wallet.entity.Problem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 问题回复管理接口
 * @author xb4876
 */
@Component //使用Component代替Mapper
public interface ProblemMapper {

    List<Problem> findList(@Param("entity") Problem entity);

    int update(Problem entity);

    void delete(String id);

    Problem findOne(int id);
}
