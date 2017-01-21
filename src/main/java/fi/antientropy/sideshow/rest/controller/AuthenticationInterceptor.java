package fi.antientropy.sideshow.rest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Configuration
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Boolean access = false;
        if(access) {
            return true;
        }
        else {
            response.sendError(HttpStatus.SC_NOT_FOUND, "Content you are looking for is not here");
            return false;
        }

    }
}