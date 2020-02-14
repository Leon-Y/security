package com.example.security_core.code;

import com.example.security_core.code.image.ImageCodeGenerator;
import com.example.security_core.code.sms.SmsCodeGenerator;
import com.example.security_core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: 36560
 * @Date: 2020/2/14 :12:30
 * @Description:
 */
@Configuration
public class ValidateCodeConfiguration {

    @Autowired
    SecurityProperties securityProperties;

    @Bean("imageCodeGenerator")
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageValidateGenerator(){
        return new ImageCodeGenerator();
    }

    @Bean("smsCodeGenerator")
    @ConditionalOnMissingBean(name="smsCodeGenerator")
    public ValidateCodeGenerator SmsCodeGenerator(){
        return new SmsCodeGenerator();
    }

}
