package com.example.demo.dto.response;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtResponse {
    String token;
    private String type = "Bearer";
    private String name;
    private Collection<? extends GrantedAuthority> roles;
    private Long id;
    private boolean status;

    public JwtResponse() {
    }

    public JwtResponse(String token, String type, String name, Collection<? extends GrantedAuthority> roles) {
        this.token = token;
        this.type = type;
        this.name = name;
        this.roles = roles;
    }

    public JwtResponse(String token, String name, Collection<? extends GrantedAuthority> authorities, Long id,
            boolean status) {
        this.token = token;
        this.name = name;
        this.roles = authorities;
        this.id = id;
        this.status = status;
    }

    public JwtResponse(String token, String name, Collection<? extends GrantedAuthority> authorities, Long id) {
        this.token = token;
        this.name = name;
        this.roles = authorities;
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
