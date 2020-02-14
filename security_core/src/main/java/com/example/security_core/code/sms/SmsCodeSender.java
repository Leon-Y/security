package com.example.security_core.code.sms;

/**
 * @Auther: 36560
 * @Date: 2020/2/14 :12:20
 * @Description:
 */
public interface SmsCodeSender {
    /**
     * 生成手机验证码
     * @param mobile 手机号
     * @param code 验证码
     */
    void send(String mobile, String code);
}
