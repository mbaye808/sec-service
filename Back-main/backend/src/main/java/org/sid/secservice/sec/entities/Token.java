package org.sid.secservice.sec.entities;

public class Token {
    
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Token(String token) {
        this.token = token;
    }

    public Token() {
    }

    @Override
    public String toString() {
        return "Token [token=" + token + "]";
    }
    
    
}
