package com.qep.ssoclient.demo.component;

/**
 * @author: sunyl-b
 * @time: 2021/2/3 10:23
 * @summary: ""
 */
//import lombok.SneakyThrows;
import org.jasig.cas.client.authentication.AuthenticationRedirectStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

//@Component
public class CustomAuthRedirectStrategy implements AuthenticationRedirectStrategy {

//    @SneakyThrows
    @Override
    public void redirect(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String s) throws IOException {
        // 自定义一个后台接口，该controller接口内只写一个response.sendRedirect(应用首页)
        String dealUrl = "http://cas.app.com/api/1.0/users/loginRedirect";
        String encodeUrl = URLEncoder.encode(dealUrl, "utf-8");
        // cas认证中心登录页地址
        String loginUrl = "http://cas.proaim.com:8080/cas/login" + "?service=" + encodeUrl;
        httpServletResponse.setStatus(401);
        PrintWriter out = httpServletResponse.getWriter();
        // 格式自定义，前端能获取到loginUrl即可
        out.write("{\"errors\":[" + "\"" + loginUrl + "\"" + "]}");
    }
}
