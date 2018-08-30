package com.renwu.backendapp.wallet.mapper;
import com.renwu.backendapp.wallet.entity.AppVersion;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 版本管理接口
 * @author xb4876
 */
@Component //使用Component代替Mapper
public interface AppVersionMapper {

    List<AppVersion> findList(@Param("entity") AppVersion entity);

    int update(AppVersion entity);

    int save(AppVersion entity);

    void delete(String id);

    AppVersion findOne(int id);

    //更新其他信息is_new
    void updateOther(@Param("entity") AppVersion entity);

    AppVersion checkVersion(@Param("version") String version);
}
