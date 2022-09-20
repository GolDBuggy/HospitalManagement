package com.java.hospitalmanagement.Config;

import com.java.hospitalmanagement.Security.MemberDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.method.MethodSecurityMetadataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {

    private final MemberDetailService service;
    private AuthenticationManager authenticationManager;


    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        AuthenticationManagerBuilder builder=httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(service);
        authenticationManager=builder.build();
        httpSecurity.csrf().disable();
        httpSecurity.authorizeRequests().antMatchers("/save").permitAll().and().
                authorizeRequests().
                antMatchers("/all","/profile","/profile/**","/disease/all","/note/save","/note/my").
                hasRole("MEMBER").and().
                authorizeRequests().antMatchers("/list/analysis","/analysis/**").hasRole("LABORATORIAN").and().
                authorizeRequests().antMatchers("/barcode/**","/analysis/all","/disease/save","/note/{personalId}").
                hasRole("DOCTOR").and().
                authorizeRequests().antMatchers("/clinic/**","/doctor/**","/hospital/**").
                hasAnyRole("ADMIN","DOCTOR").and().
                authorizeRequests().antMatchers("/change/**").hasRole("ADMIN").and().
                formLogin().permitAll()
                .and().logout().permitAll().and().authenticationManager(authenticationManager).httpBasic();
        return  httpSecurity.build();
    }


}
