package com.qep.ssoclient.demo.config;

import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: sunyl-b
 * @time: 2021/2/1 15:44
 * @summary: ""
 */

@Configuration
public class CasFilterConfig{
    @Value("${cas.server-url-prefix}")
    private String serverUrlPrefix;
    @Value("${cas.server-login-url}")
    private String serverLoginUrl;
    @Value("${cas.client-host-url}")
    private String clientHostUrl;

    /**
     * 授权过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean filterAuthenticationRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new AuthenticationFilter());//注册过滤器
        // 设定匹配的路径
        registration.addUrlPatterns("/*");//过滤所有路径
        Map<String,String> initParameters = new HashMap<>();
        initParameters.put("casServerLoginUrl", serverLoginUrl);
        initParameters.put("serverName", clientHostUrl);
        //忽略的url，"|"分隔多个url
        System.out.printf(initParameters.get("serverName"));
        registration.setInitParameters(initParameters);
        // 设定加载的顺序
        registration.setOrder(1);//优先级，最顶级
        return registration;
    }
}
