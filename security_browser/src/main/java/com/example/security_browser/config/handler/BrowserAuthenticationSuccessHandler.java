package com.example.security_browser.config.handler;

import com.example.security_core.enums.LoginType;
import com.example.security_core.properties.SecurityProperties;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: 36560
 * @Date: 2020/2/13 :13:42
 * @Description:
 */
@Component
public class BrowserAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private SecurityProperties securityProperties;

    private RequestCache requestCache = new HttpSessionRequestCache();

    @Override
    public void setRequestCache(RequestCache requestCache) {
        this.requestCache = requestCache;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())){
            response.getWriter().write(objectMapper.writeValueAsString(authentication));
            response.setContentType("application/json;charset=UTF-8");
        }else {
            SavedRequest savedRequest = requestCache.getRequest(request, response);
            if (savedRequest != null ){
                String redirectUrl = savedRequest.getRedirectUrl();
                if (StringUtils.isBlank(redirectUrl)){
                    getRedirectStrategy().sendRedirect(request, response, "/index.html");
                }
            }else if (savedRequest == null){
                getRedirectStrategy().sendRedirect(request, response, "/index.html");
            }
            super.onAuthenticationSuccess(request,response,authentication);
        }

    }
}
