package com.tobeto.pair9.entities.concretes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public enum Role implements GrantedAuthority {

    USER,
    ADMIN;


    @Override
    public String getAuthority() {
        return null;
    }
}
