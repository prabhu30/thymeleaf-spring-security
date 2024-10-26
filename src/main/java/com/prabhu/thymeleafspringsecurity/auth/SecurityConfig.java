package com.prabhu.thymeleafspringsecurity.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails userRoy = User.builder()
                .username("roy")
                .password("{noop}yor123")
                .roles("EMPLOYEE").build();

        UserDetails userWilliam = User.builder()
                .username("william")
                .password("{noop}willy123")
                .roles("EMPLOYEE", "ADMIN").build();

        UserDetails userJake = User.builder()
                .username("jake")
                .password("{noop}cage123")
                .roles("EMPLOYEE", "ADMIN", "MANAGER").build();

        return new InMemoryUserDetailsManager(userRoy, userWilliam, userJake);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configurer -> configurer.anyRequest().authenticated())
                .formLogin(form -> form.loginPage("/auth").loginProcessingUrl("/authenticateUser").permitAll())
                .logout(logout -> logout.permitAll());
        return httpSecurity.build();
    }
}
