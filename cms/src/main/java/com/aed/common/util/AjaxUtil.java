package com.aed.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Ajax Util
 */
public class AjaxUtil {

    public static boolean isAjaxRequest(HttpServletRequest request) {
        String xmlHttpRequest = request.getHeader("X-Requested-With");
        return (xmlHttpRequest != null && xmlHttpRequest.equalsIgnoreCase("XMLHttpRequest"));
    }
}
