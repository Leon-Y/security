package com.example.security_core.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Auther: 36560
 * @Date: 2020/2/14 :9:27
 * @Description:
 */
public interface ValidateCodeGenerator {

    public static String SESSION_KEY = "";

    /**
     * 生成校验码
     * @param request
     * @return
     */
    ValidateCode generate(ServletWebRequest request);

    /**
     * 是否适用于当前的处理器
     * @param request
     * @return
     */
    boolean support(ServletWebRequest request);

}
