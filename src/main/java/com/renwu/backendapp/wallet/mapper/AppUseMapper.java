package com.renwu.backendapp.wallet.mapper;

import com.renwu.backendapp.wallet.entity.AppUse;

/**
 *  应用使用情况记录，分为装机和日活的用户使用行为记录，用于统计分析装机量和日活跃用户量
 *  @author ChenZhang
 */
public interface AppUseMapper {
    /**
     * 添加应用使用情况记录
     * @param appUse 应用使用情况记录
     * @return 操作是否成功
     */
    public boolean addAppUse(AppUse appUse);
}
