package com.renwu.backendapp.wallet.mapper;

import com.renwu.backendapp.wallet.entity.AppUse;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *  应用使用情况记录，分为装机和日活的用户使用行为记录，用于统计分析装机量和日活跃用户量
 *  @author ChenZhang
 */
@Component
public interface AppUseMapper {

    /**
     * 查询app用户数量
     * @return
     */
    int userCount();

    /**
     * 查询日活跃量
     * @return
     */
    int dayActive();

    /**
     * 周活跃量
     * @return
     */
    List<AppUse> weekActive();

    /**
     * 根据手机型号统计安装数量
     * @return
     */
    List<AppUse> devCount();
}
