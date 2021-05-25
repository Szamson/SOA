package pl.soa.lab.auth;


import io.jsonwebtoken.Jwts;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.security.Key;


@Provider
@pl.soa.lab.auth.JWTTokenNeeded
@Priority(Priorities.AUTHENTICATION)
public class JWTTokenNeededFilter implements ContainerRequestFilter {

    @Inject
    private KeyGenInterface keyGenerator;

    @Override
    public void filter(ContainerRequestContext requestContext) {

        //Get the HTTP Authorization request
        try {
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        //Extract the token
        String token = authorizationHeader.substring("token".length()).trim();


            // Validate the token
            Key key = keyGenerator.generateKey();
            Jwts.parser().setSigningKey(key).parseClaimsJws(token);

        } catch (Exception e) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }
}
