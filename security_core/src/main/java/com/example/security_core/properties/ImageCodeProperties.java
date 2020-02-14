package com.example.security_core.properties;

import lombok.Data;

/**
 * @Auther: 36560
 * @Date: 2020/2/14 :9:50
 * @Description:
 */
@Data
public class ImageCodeProperties extends SmsCodeProperties{
    private int hight = 6;
    private int width = 60;
}
