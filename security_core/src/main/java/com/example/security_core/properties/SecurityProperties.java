package com.example.security_core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * @Auther: 36560
 * @Date: 2020/2/13 :12:31
 * @Description:
 */
@ConfigurationProperties(prefix = "security.core")
@Data
public class SecurityProperties {
    @NestedConfigurationProperty
    private BrowserProperties browser = new BrowserProperties();
    @NestedConfigurationProperty
    private ValidateCodeProperties code;
}
