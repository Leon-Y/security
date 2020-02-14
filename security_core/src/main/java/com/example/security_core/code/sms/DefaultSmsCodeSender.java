package com.example.security_core.code.sms;

/**
 * @Auther: 36560
 * @Date: 2020/2/14 :12:21
 * @Description:
 */
public class DefaultSmsCodeSender implements SmsCodeSender {
    @Override
    public void send(String mobile, String code) {
        System.out.println("短信发送给"+mobile+"用户："+code);
    }
}
