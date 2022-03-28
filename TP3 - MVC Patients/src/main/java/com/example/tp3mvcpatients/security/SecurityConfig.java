package com.example.tp3mvcpatients.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder passwordEncoder = passwordEncoder();
        auth.inMemoryAuthentication()
                .withUser("user1").password(passwordEncoder.encode("1234")).roles("USER")
                .and().withUser("admin").password(passwordEncoder.encode("1234")).roles("USER","ADMIN");
        // les utilisateurs qu'on le droit d'acceder a l'application seront stocker au mémoire
        // {noop} no password encoder

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception { // droits d'acces
        // http.formLogin().loginPage("/login");
        http.formLogin();
        http.authorizeHttpRequests().antMatchers("/delete/**","/new/**","/create/**","/update/**").hasRole("ADMIN");
        http.authorizeHttpRequests().antMatchers("/index/**").hasRole("USER");
        http.authorizeHttpRequests().anyRequest().authenticated();
        http.exceptionHandling().accessDeniedPage("/403");

    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
