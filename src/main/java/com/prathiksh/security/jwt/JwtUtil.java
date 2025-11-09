package com.prathiksh.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JwtUtil {

    private static String key = "3f2d7f42-6b9b-4d4b-9c1e-d46e4f6893dc";

    public JwtUtil() {
    }

    public String generateToken(String username) {
        return JWT.create()
                .withHeader(Map.of("algo","Hmac"))
                .withClaim("username",username)
                .sign(Algorithm.HMAC256(key));
    }
}
