package com.example.security_core.code.image;

import com.example.security_core.code.ValidateCode;
import lombok.Data;

import java.awt.image.BufferedImage;

/**
 * @Auther: 36560
 * @Date: 2020/2/13 :16:31
 * @Description:
 */
@Data
public class ImageCode extends ValidateCode {

    private BufferedImage bufferedImage;

    public ImageCode(String code ,BufferedImage bufferedImage, int expireIn) {
        super(code,expireIn);
        this.bufferedImage = bufferedImage;
    }
}
