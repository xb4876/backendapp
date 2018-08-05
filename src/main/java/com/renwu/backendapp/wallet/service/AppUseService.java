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
        return mapper.dayActive();
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
}
