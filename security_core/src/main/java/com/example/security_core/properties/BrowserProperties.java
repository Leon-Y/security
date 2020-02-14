package com.example.security_core.properties;

import com.example.security_core.enums.LoginType;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Auther: 36560
 * @Date: 2020/2/13 :12:31
 * @Description:
 */
@Data
@ConfigurationProperties(prefix = "")
public class BrowserProperties {
    private String loginPage = "/signIn.html";

    private LoginType loginType = LoginType.REDIRECT;

    private int rememberMeSeconds = 3600;
}
