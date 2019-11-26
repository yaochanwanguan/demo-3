package com.datangedu.cn.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户操作
 */
public class UserUtil {
    private UserUtil(){}

    public static String getUserId(HttpServletRequest request){
        String userId = null;
        //获得用户id
        Cookie[] cookis = request.getCookies();
        for (int i = 0; i < cookis.length; i++){
            if("USER".equals(cookis[i].getName())){
                userId = cookis[i].getValue();
                break;
            }
        }
        return userId;
    }
}
