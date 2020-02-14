package com.example.security_core.properties;

import lombok.Data;

/**
 * @Auther: 36560
 * @Date: 2020/2/14 :9:50
 * @Description:
 */
@Data
public class SmsCodeProperties {

    /**
     * 验证码长度
     */
    private int length = 6;

    /**
     * 验证码过期时间
     */
    private int expireIn = 60;

    /**
     * 需要进行校验的url，逗号隔开
     */
    private String url = "/code/sms";

}
