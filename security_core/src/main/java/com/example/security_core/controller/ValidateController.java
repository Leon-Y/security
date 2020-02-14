package com.example.security_core.controller;

import com.example.security_core.code.ValidateCodeGenerator;
import com.example.security_core.code.image.ImageCode;
import com.example.security_core.code.sms.SmsCode;
import com.example.security_core.code.sms.SmsCodeSender;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: 36560
 * @Date: 2020/2/13 :16:35
 * @Description:
 */
@RestController
public class ValidateController {

    @Resource(name = "imageCodeGenerator")
    private ValidateCodeGenerator imageCodeGenerator;

    @Resource(name = "smsValidateCodeGenerator")
    private ValidateCodeGenerator smsCodeGenerator;

    @Resource
    private SmsCodeSender smsCodeSender;
    /**
     * 图片验证码key
     */
    public static final String SESSION_KEY_IMAGE = "SESSION_KEY_IMAGE_CODE";

    /**
     * 消息验证码key
     */
    public static final String SESSION_KEY_SMS = "SESSION_KEY_SMS_CODE";

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @GetMapping("/code/image")
    public void creatCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ImageCode generate = (ImageCode) imageCodeGenerator.generate(new ServletWebRequest(request, response));
        sessionStrategy.setAttribute(new ServletWebRequest(request, response), SESSION_KEY_IMAGE, generate);
        ImageIO.write(generate.getBufferedImage(), "jpeg", response.getOutputStream());
    }

    @GetMapping("/code/sms")
    public void creatSmsCode(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletRequestBindingException {
        SmsCode generate = (SmsCode) smsCodeGenerator.generate(new ServletWebRequest(request, response));
        sessionStrategy.setAttribute(new ServletWebRequest(request, response), SESSION_KEY_SMS, generate);
        String mobile = ServletRequestUtils.getRequiredStringParameter(request, "mobile");
        smsCodeSender.send(mobile, generate.getCode());
    }
}
