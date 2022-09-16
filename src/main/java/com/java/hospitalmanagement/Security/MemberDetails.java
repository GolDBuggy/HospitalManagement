package com.java.hospitalmanagement.Security;

import com.java.hospitalmanagement.Model.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MemberDetails implements UserDetails {

    private String personalId;
    private String password;
    private List<GrantedAuthority> roles;
    private boolean activity;

    public MemberDetails(Member member) {
        this.personalId = member.getPersonalId();
        this.password = member.getPassword();
        this.roles = Arrays.stream(member.getRoles().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        this.activity = member.isActivity();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return personalId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return activity;
    }
}
