//package com.task.best.security.jwt;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.task.best.dto.User;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Date;
//
//import static com.task.best.security.jwt.SecurityConstants.*;
//
//public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//    private AuthenticationManager authenticationManager;
//
//    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest req,
//                                                HttpServletResponse res) throws AuthenticationException {
//        try {
//            //client's sended credintials pasted into new User class which is "cred"
//            User creds = new ObjectMapper()
//                    .readValue(req.getInputStream(), User.class);
//
//            //We change class into Authentication with help of UsernamePasswordAuthenticationToken
//            Authentication authentication = new UsernamePasswordAuthenticationToken(
//                            creds.getEmail(),
//                            creds.getPassword(),
//                            new ArrayList<>());
//
//            //now we are checking username, password and roles. if true, immediately method below invokes
//            return authenticationManager.authenticate(authentication);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    //we know if, validation is ok, server should FORMULATE and send token to client
//    @Override
//    protected void successfulAuthentication(HttpServletRequest req,
//                                            HttpServletResponse res,
//                                            FilterChain chain,
//                                            Authentication auth) throws IOException {
////        1. JWT
////        String token = JWT.create()
////                .withSubject(auth.getName())
////                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
////                .sign(Algorithm.HMAC512(SECRET.getBytes()));
//
////        2. JWTS
//        String token=  Jwts.builder()
//                .setSubject(auth.getName())
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()))
//                .compact();
//
//        res.addHeader("Authorization",TOKEN_PREFIX+token);
//
//    }
//
//}
