package com.example.security_core.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @Auther: 36560
 * @Date: 2020/2/13 :17:41
 * @Description:
 */
public class ValidateCodeException extends AuthenticationException {
    public ValidateCodeException(String msg, Throwable t) {
        super(msg, t);
    }

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
