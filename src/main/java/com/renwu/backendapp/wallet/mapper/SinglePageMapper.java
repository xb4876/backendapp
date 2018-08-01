package com.renwu.backendapp.wallet.mapper;

import com.renwu.backendapp.wallet.entity.SinglePage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 单页管理接口
 * @author xb4876
 */
@Component //使用Component代替Mapper
public interface SinglePageMapper {

    SinglePage selectById(Integer id);

    List<SinglePage> findList(@Param("entity") SinglePage entity);

    int update(SinglePage entity);

    int save(SinglePage entity);

    void delete(String id);

    SinglePage findOne(int id);
}
