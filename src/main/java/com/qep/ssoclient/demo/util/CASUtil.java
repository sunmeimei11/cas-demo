package com.qep.ssoclient.demo.util;

import org.apache.commons.lang.StringUtils;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.AbstractCasFilter;
import org.jasig.cas.client.validation.Assertion;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: sunyl-b
 * @time: 2021/2/1 15:43
 * @summary: ""
 */
public class CASUtil {
    /**
     * 从cas中获取用户名
     *
     * @param request
     * @return
     */
    public static String getAccountNameFromCas(HttpServletRequest request) {
        Assertion assertion = (Assertion) request.getSession().getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION);
        if(assertion!= null){
            AttributePrincipal principal = assertion.getPrincipal();
            return principal.getName();
        }else return null;

    }

//     public static boolean hasTicket(HttpServletRequest request) {
//        Object ticket = request.getParameter(Constants.TICKET_KEY);
//        return ticket != null && !StringUtils.isEmpty(String.valueOf(ticket)); }

}
