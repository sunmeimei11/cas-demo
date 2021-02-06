package com.qep.ssoclient.demo.controller;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.AbstractCasFilter;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author: sunyl-b
 * @time: 2021/2/1 16:03
 * @summary: ""
 */

@Controller
public class TestController {

    @Value(value = "${cas.server-url-prefix}")
    private String serverUrlPrefix = "";

    @Value(value = "${cas.client-host-url}")
    private String clientHostUrl = "";

    @GetMapping("user")
    @ResponseBody
    public String user(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Assertion assertion = (Assertion) request.getSession().getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION);
        String loginName = null;
        if (assertion != null) {
            AttributePrincipal principal = assertion.getPrincipal();
            loginName = principal.getName();
            System.out.println("访问者:" + loginName);
        }
//        return "访问者:" + loginName;
        response.sendRedirect("http://127.0.0.1:8000");
        return "";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:" + serverUrlPrefix + "/logout?service=" + clientHostUrl+"/user";
    }
}
