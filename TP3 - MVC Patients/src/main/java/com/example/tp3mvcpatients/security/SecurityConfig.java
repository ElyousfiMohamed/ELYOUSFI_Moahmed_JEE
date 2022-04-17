package com.example.tp3mvcpatients.security;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collection;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        /*
        PasswordEncoder passwordEncoder = passwordEncoder();
        auth.inMemoryAuthentication()
                .withUser("user1").password(passwordEncoder.encode("1234")).roles("USER")
                .and().withUser("admin").password(passwordEncoder.encode("1234")).roles("USER","ADMIN");

        // les utilisateurs qu'on le droit d'acceder à l'application seront stocker au mémoire
        // {noop} no password encoder


        PasswordEncoder passwordEncoder = passwordEncoder();
        System.out.println(passwordEncoder.encode("1234"));
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("Select username, password, active from users where username = ?")
                .authoritiesByUsernameQuery("Select username, role from users_role where username = ?")
                .rolePrefix("ROLE_")
                .passwordEncoder(passwordEncoder); */

        auth.userDetailsService(userDetailsService);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception { // droits d'acces
        // http.formLogin().loginPage("/login");
        http.formLogin();
        http.authorizeHttpRequests().antMatchers("/admin/**").hasRole("ADMIN");
        http.authorizeHttpRequests().antMatchers("/index/**").hasRole("USER");
        http.exceptionHandling().accessDeniedPage("/403");
        http.authorizeHttpRequests().anyRequest().authenticated();

    }
}
