//package com.qep.ssoclient.demo.config;
//
///**
// * @author: sunyl-b
// * @time: 2021/2/1 17:21
// * @summary: ""
// */
//
//import com.qep.ssoclient.demo.util.CASUtil;
//import org.apache.commons.lang.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
//public class LocalUserInfoFilter implements Filter {
//    Logger logger = LoggerFactory.getLogger(LocalUserInfoFilter.class);
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest request_ = (HttpServletRequest) request;
//        String loginName = CASUtil.getAccountNameFromCas(request_);
//        if (StringUtils.isNotEmpty(loginName)) {
//            logger.info("访问者 ：" + loginName);
//            request_.getSession().setAttribute("loginName", loginName);
//        }
//
//        chain.doFilter(request, response);
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
