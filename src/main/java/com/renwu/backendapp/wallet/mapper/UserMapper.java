package com.renwu.backendapp.wallet.mapper;


import com.renwu.backendapp.wallet.entity.User;
import org.springframework.stereotype.Component;

/**
 * 操作用户
 * @author xb4876
 */
@Component //使用Component代替Mapper
public interface UserMapper {
    User selectByUserName(String username);
    User selectById(String id);

}
