package com.example.security_core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * @Auther: 36560
 * @Date: 2020/2/14 :9:47
 * @Description:
 */
@Data
public class ValidateCodeProperties {
    @NestedConfigurationProperty
    private SmsCodeProperties sms;
    @NestedConfigurationProperty
    private ImageCodeProperties imageCodeProperties;
}
