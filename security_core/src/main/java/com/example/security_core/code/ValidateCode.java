package com.example.security_core.code;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @Auther: 36560
 * @Date: 2020/2/14 :8:18
 * @Description:
 */
@Getter
@Setter
public class ValidateCode {
    private String code;
    private LocalDateTime expireTime;

    public ValidateCode(String code, int expireIn) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }
}
