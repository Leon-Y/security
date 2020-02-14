/**
 * 
 */
package com.example.security_core.code.sms;

import com.example.security_core.code.ValidateCode;
import com.example.security_core.code.ValidateCodeGenerator;
import com.example.security_core.properties.SecurityProperties;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 短信验证码生成器
 * 
 * @author zhailiang
 *
 */
@Component("smsValidateCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

	@Autowired
	private SecurityProperties securityProperties;

	private static final String TYPE = "smsCode";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.imooc.security.core.validate.code.ValidateCodeGenerator#generate(org.
	 * springframework.web.context.request.ServletWebRequest)
	 */
	@Override
	public ValidateCode generate(ServletWebRequest request) {
		String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
		return new ValidateCode(code, securityProperties.getCode().getSms().getExpireIn());
	}

    @Override
    public boolean support(ServletWebRequest request){
        String validateCodeType = null;
        try {
            validateCodeType = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), "validateCodeType");
        } catch (ServletRequestBindingException e) {
            return false;
        }
        if (!StringUtils.isBlank(validateCodeType) && TYPE.equals(validateCodeType)){
            return true;
        }
        return false;
    }

    public SecurityProperties getSecurityProperties() {
		return securityProperties;
	}

	public void setSecurityProperties(SecurityProperties securityProperties) {
		this.securityProperties = securityProperties;
	}
	
	

}
