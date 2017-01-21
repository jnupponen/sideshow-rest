package fi.antientropy.sideshow.rest.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import fi.antientropy.sideshow.rest.service.LocationService;

@Configuration
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    private static final String TOKEN = "token";
    private static final String OWNER_TOKEN = "owner_token";

    @Autowired
    private LocationService locationService;

    // /api/locations/<id> ID is at location 3
    private static final Integer ID = 3;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try {
            String token = request.getHeader(TOKEN);
            String ownerToken = request.getHeader(OWNER_TOKEN);

            String[] parts = request.getRequestURI().split("/");
            // Will throw exception if outofbounds.
            String id = parts[ID];

            if("PUT".equals(request.getMethod())) {
                return Optional.of(locationService.checkModifyAccess(id, token, ownerToken))
                        .filter(access -> access)
                        .orElseThrow(() ->  new Exception("Unauthorized"));
            }
            else if("GET".equals(request.getMethod())) {
                return Optional.of(locationService.checkReadAccess(id, token))
                        .filter(access -> access)
                        .orElseThrow(() ->  new Exception("Unauthorized"));
            }
            else {
                throw new Exception("Unauthorized");
            }
        }
        catch(Exception e) {
            response.sendError(HttpStatus.SC_NOT_FOUND, "Content you are looking for is not here");
            return false;
        }


    }
}