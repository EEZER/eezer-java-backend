package org.eezer.service.security.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eezer.api.enums.EezerErrorCode;
import org.eezer.api.response.EezerErrorResponse;
import org.eezer.service.domain.service.JwtService;
import org.eezer.service.security.annotation.AuthSecured;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JWTAuthInterceptor extends HandlerInterceptorAdapter {

    private JwtService jwtService;

    private static final String AUTHORIZATION_HEADER = "Authorization";

    public JWTAuthInterceptor(JwtService jwtService) {

        this.jwtService = jwtService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try {

            HandlerMethod handlerMethod = (HandlerMethod) handler;

            AuthSecured authenticated = handlerMethod.getMethod().getAnnotation(AuthSecured.class);

            if (authenticated == null) {
                return true;
            }

            log.info("Request to access secured url, url: {}", request.getContextPath());

            String token = jwtService.getTokenFromAuthHeader(request.getHeader(AUTHORIZATION_HEADER));
            jwtService.validateAccessToken(token, authenticated.role().name());

            return true;

        } catch (Exception e) {

            this.setAuthFailedResponse(response);
            return false;
        }
    }


    private void setAuthFailedResponse(HttpServletResponse response) throws IOException {

        EezerErrorResponse errorResponse = new EezerErrorResponse(false,
                EezerErrorCode.Unauthorized.name(), null);

        String json = new ObjectMapper().writeValueAsString(errorResponse);

        response.setHeader("Content-Type", "application/json");
        response.setStatus(403);
        response.getWriter().write(json);
        response.getWriter().flush();
        response.getWriter().close();
    }
}
