package com.example.security_browser.config.model;

import lombok.Data;

/**
 * @Auther: 36560
 * @Date: 2020/2/13 :12:02
 * @Description:
 */
@Data
public class SimpleResponse {
    private String message;

    public SimpleResponse(String message) {
        this.message = message;
    }
}
