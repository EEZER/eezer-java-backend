package org.eezer.service.config;

import javax.annotation.Resource;

import org.eezer.service.domain.service.JwtService;
import org.eezer.service.security.interceptor.JWTAuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RequestInterceptorConfig implements WebMvcConfigurer {

    @Resource
    private JwtService jwtService;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTAuthInterceptor(jwtService));
    }

}
