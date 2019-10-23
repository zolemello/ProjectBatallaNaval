package com.javapractice.prueba.security;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JWTRepository {
    public static final JWTRepository instance = new JWTRepository();
    private List<String> tokens = new ArrayList<>();


    private JWTRepository() {
    }

    public static JWTRepository getInstance() {
        return instance;
    }

    public void addToken(String token) {
        this.tokens.add(token);
    }

    public void removeToken(String token) {
        this.tokens.remove(token);
    }

    public boolean hasToken(String token) {
        return this.tokens.contains(token);
    }

    public String create(String username, boolean isAdmin) {
        String token = JWT.create()
                .withSubject(username)
                .withClaim("admin", isAdmin)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(HMAC512(SECRET.getBytes()));
        addToken(token);
        return token;
    }

    public String decode(String token) {
        return JWT.require(HMAC512(SECRET.getBytes()))
                .build()
                .verify(token)
                .getSubject();
    }
}
