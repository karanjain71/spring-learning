package com.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.blog.security.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class SpringConfig {
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()).authorizeHttpRequests().anyRequest().authenticated().and().httpBasic();
		return http.build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder) 
	  throws Exception {
	    return http.getSharedObject(AuthenticationManagerBuilder.class)
	      .userDetailsService(customUserDetailService)
	      .passwordEncoder(bCryptPasswordEncoder)
	      .and()
	      .build();
	}
	@Bean
	public PasswordEncoder passwordEncoder()
	{
	    return new BCryptPasswordEncoder();
	}
}
