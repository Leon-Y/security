package com.example.security_core.code.sms;

import com.example.security_core.code.ValidateCode;
import lombok.Data;

/**
 * @Auther: 36560
 * @Date: 2020/2/14 :8:17
 * @Description:
 */
@Data
public class SmsCode extends ValidateCode {

    public SmsCode(String code, int expireIn) {
        super(code, expireIn);
    }
}
