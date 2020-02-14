package com.example.security_core.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

/**
 * @Auther: 36560
 * @Date: 2020/2/14 :13:12
 * @Description:
 */
public abstract class abstractValidateCodeProcessor<E extends ValidateCode> implements ValidateCodeProcessor {

    /**
     * 自动注入所有的验证码生成器
     */
    @Autowired
    private Map<String,ValidateCodeGenerator> validateCodeGenerators;

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Override
    public void create(ServletWebRequest request) {
        ValidateCodeGenerator generator = getGenerator(request);

    }

    @Override
    public void validate(ServletWebRequest request) {

    }

    /**
     * 获取enerator
     * @param request
     * @return
     */
    public ValidateCodeGenerator getGenerator(ServletWebRequest request){
        for (ValidateCodeGenerator validateCodeGenerators:validateCodeGenerators.values()){
            if (validateCodeGenerators.support(request)){
                return validateCodeGenerators;
            }
        }
        return null;
    }

    private void save(ServletWebRequest request,ValidateCodeGenerator validateCodeGenerator){
        if (validateCodeGenerator != null){
            ValidateCode generate = validateCodeGenerator.generate(request);
            sessionStrategy.setAttribute(request,validateCodeGenerator.SESSION_KEY,generate);
        }
    }

    protected abstract void send(ServletWebRequest request,ValidateCodeGenerator validateCodeGenerator);
}
