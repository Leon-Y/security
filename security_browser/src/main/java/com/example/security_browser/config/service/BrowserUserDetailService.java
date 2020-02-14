package com.example.security_browser.config.service;

import com.example.security_browser.config.model.User;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Auther: 36560
 * @Date: 2020/2/13 :10:17
 * @Description:
 */
@Component
@Slf4j
public class BrowserUserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.debug("用户登录："+userName);
        return new User("admin",passwordEncoder.encode("123456"),AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
