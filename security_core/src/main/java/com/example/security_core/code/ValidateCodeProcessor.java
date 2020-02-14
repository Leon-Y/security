package com.example.security_core.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Auther: 36560
 * @Date: 2020/2/14 :13:08
 * @Description:
 */
public interface ValidateCodeProcessor {
    /**
     * 创建校验码
     * @param request
     */
    void create(ServletWebRequest request);

    /**
     * 校验验证码
     * @param request
     */
    void validate(ServletWebRequest request);
}
