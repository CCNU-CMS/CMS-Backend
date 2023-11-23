package com.cmsbackend.intercept;


import com.cmsbackend.base.ResultData;
import com.cmsbackend.base.ReturnCode;
import com.cmsbackend.utils.JWT.JwtTokenUtil;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtIntercept implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception {
        //表示接受任意域名的请求,也可以指定域名
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
        //该字段可选，是个布尔值，表示是否可以携带cookie
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "*");

        // 预检处理，方行所有非简单请求方法
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            return true;
        }

        String token = request.getHeader("Authorization");
        System.out.println(JwtTokenUtil.getUserAccountFromToken(token));
//        System.out.println(token);
        try {
            JwtTokenUtil.validateToken(token);

        }catch (Exception e) {
            ResultData.fail(ReturnCode.RC204.getCode(), e.getMessage());
            return false;
        }
        request.setAttribute("account",JwtTokenUtil.getUserAccountFromToken(token));
//        System.out.println(JwtTokenUtil.getUserEmailFromToken(token));
//        //将map转为json
//        String json = new ObjectMapper().writeValueAsString(map);
//        response.setContentType("application/json;charset=UTF-8");
//        response.getWriter().println(json);
        return true;
    }
}
