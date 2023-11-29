package com.cmsbackend.config;

import com.cmsbackend.intercept.JwtIntercept;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        JwtTokenUtil jwtTokenUtil = null;
        registry.addInterceptor(new JwtIntercept())
                //.addPathPatterns("/user/test")  //需要token验证的都这样写
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/admin/add"); //不需要token验证的都这样写
    }
}
