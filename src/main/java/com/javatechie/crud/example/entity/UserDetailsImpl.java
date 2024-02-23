package com.javatechie.crud.example.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {

    private final User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles().stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // You can implement account expiration logic if needed
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // You can implement account locking logic if needed
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // You can implement credentials expiration logic if needed
    }

    @Override
    public boolean isEnabled() {
        return true; // You can implement user enable/disable logic if needed
    }
}
