package com.renwu.backendapp.wallet.service;

import com.renwu.backendapp.wallet.entity.AppUse;
import com.renwu.backendapp.wallet.mapper.AppUseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUseService {

    @Autowired
    AppUseMapper mapper;

    /**
     * 用户数量
     */
    public int userCount() {
        return mapper.userCount();
    }

    /**
     * 日活跃量
     */
    public int dayActive() {
        int useType = 2;//日活
        return mapper.dayCount(useType);
    }

    /**
     * 周活跃量
     * @return
     */
    public List<AppUse> weekActive() {
        return mapper.weekActive();
    }

    /**
     * 根据手机型号统计安装数量
     * @return
     */
    public List<AppUse> devCount() {
        return mapper.devCount();
    }

    /**
     * 新增装机量（当天）
     * @return
     */
    public int newUseCount() {
        int useType = 1;//装机
        return mapper.dayCount(useType);
    }

    /**
     * 累计装机量
     * @return
     */
    public int allUseCount() {
        int useType = 1;//装机
        return mapper.allCount(useType);
    }

    /**
     * 累计活跃数量
     * @return
     */
    public int allActiveCount() {
        int useType = 2;//日活
        return mapper.allCount(useType);
    }
}
