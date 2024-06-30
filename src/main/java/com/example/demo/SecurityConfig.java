package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests(request -> request.anyRequest().authenticated())       // <  5.6
//        http.authorizeHttpRequests(request -> request.anyRequest().authenticated())   // >= 5.6
        /**
         *  - 모든 경로 : anyRequest()
         *  - 일부 경로 : requestMatchers(new AntPathRequestMatcher("/admin/**"))
         */
        http.authorizeHttpRequests(request -> request.requestMatchers(new AntPathRequestMatcher("/admin/**")).authenticated())
            .authorizeHttpRequests(request -> request.requestMatchers(new AntPathRequestMatcher("/*")).permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers(new AntPathRequestMatcher("/favicon.ico"))
                .requestMatchers(new AntPathRequestMatcher("/public/*"));
    }

}
