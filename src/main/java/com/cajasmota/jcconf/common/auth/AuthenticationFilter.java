package com.cajasmota.jcconf.common.auth;

import com.cajasmota.jcconf.common.exceptions.WSException;
import com.cajasmota.jcconf.users.User;
import com.cajasmota.jcconf.users.UsersService;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

    @Inject
    UsersService usersService;

    @Inject
    CurrentUserHolder currentUserHolder;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String authorization = requestContext.getHeaderString("Authorization");
        //this should be a token with token logic, for demo purposes is just the email

        User user = usersService.byEmail(authorization);

        if (user == null) {
            throw new WSException("Unauthorized").as(Response.Status.UNAUTHORIZED);
        }

        currentUserHolder.set(user.getId(), user.getName(), user.getEmail());
    }

}
