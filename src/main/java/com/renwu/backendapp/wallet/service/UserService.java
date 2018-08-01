package com.renwu.backendapp.wallet.service;

import com.renwu.backendapp.wallet.mapper.UserMapper;
import com.renwu.backendapp.wallet.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 用户service
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserMapper mapper;

    /**
     * 登陆验证
     * @param username 用户名
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = mapper.selectByUserName(username);

        if( user == null ){
            throw new UsernameNotFoundException(String.format("User with username=%s was not found", username));
        }

        return user;
    }

}
