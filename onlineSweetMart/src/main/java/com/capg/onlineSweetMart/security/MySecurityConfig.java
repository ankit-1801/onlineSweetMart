package com.capg.onlineSweetMart.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableWebSecurity
public class MySecurityConfig {
    
	private static final String[] AUTH_WHITELIST = {
	        "/swagger-resources/**",
	        "/swagger-ui.html",
	        "/v2/api-docs",
	        "/webjars/**"
	};
	
	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http  
		.csrf()
		.disable()
		.authorizeRequests()
		.antMatchers("/token").permitAll()
		.antMatchers("/swagger-ui/**").permitAll()
		.antMatchers("/user/**").permitAll()
		.antMatchers("/item/**").permitAll()
		.antMatchers("/order/**").permitAll()
		.antMatchers("/images/**").permitAll()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.cors().disable();
	    http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	    http.authenticationProvider(daoAuthenticationProvider()); 
	    DefaultSecurityFilterChain defaultSecurityFilterChain  =http.build();

	    return defaultSecurityFilterChain;
	}
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(customUserDetailsService);
//	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(this.customUserDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	
	
	
//	@Bean
//	public void configure(WebSecurity web) throws Exception {
//	    web.ignoring().antMatchers(AUTH_WHITELIST);
//	}
	
	@Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers(AUTH_WHITELIST);
    }
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http  
//		.csrf()
//		.disable()
//		.authorizeRequests()
//		.antMatchers("/token").permitAll()
////		.access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
//		.antMatchers("/user/**").permitAll()
//		.antMatchers("/admin/**").hasRole("ADMIN")
//		.antMatchers("/orders/**").permitAll()
//		.antMatchers("/images/**").permitAll()
//		.antMatchers("/swagger-ui/**").permitAll()
//		.antMatchers("/items/**").permitAll()
//		.antMatchers("/public_items/getAllItems").permitAll()
//		.anyRequest().authenticated()
//		.and()
//		.sessionManagement()
//		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		http.cors().disable();
//	
//	    http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//	}
	
	
//	@Override
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
	
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return  NoOpPasswordEncoder.getInstance();
	}
	

}
