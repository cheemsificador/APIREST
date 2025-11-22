package com.idat.apirest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/interno").authenticated()
                .requestMatchers("/api/publico").permitAll()
                .requestMatchers("/api/admin/**").hasRole("ADMIN") 
                .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults());  

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
   
        users.setUsersByUsernameQuery(
            "select username, password, enabled from users where username = ?");
        
        users.setAuthoritiesByUsernameQuery(
            "select username, authority from authorities where username = ?");

        return users;
    }
}
