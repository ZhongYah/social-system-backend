package com.zeoubob.social.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        return http
//                // 設定 Session 的創建機制
//                .sessionManagement(session -> session
//                        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
//                )
//
//                .csrf(AbstractHttpConfigurer::disable)
//
//                .httpBasic(Customizer.withDefaults())
//
//
//                .authorizeHttpRequests(request -> request
//                        // 註冊帳號功能
//                        .requestMatchers("/register").permitAll()
//
//                        // 登入功能
//                        .requestMatchers("/userLogin").authenticated()
//
//                        .anyRequest().authenticated()
//                )
//
//                .build();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())
                .formLogin((Customizer.withDefaults()))
                .authorizeHttpRequests(request -> request
                        // 註冊帳號功能
                        .requestMatchers("/register").permitAll()

                        // 登入功能
                        .requestMatchers("/userLogin").authenticated()

                        .anyRequest().authenticated()
                )
                .cors(cors -> cors.configurationSource(corsConfig()))
                .build();
    }

    private CorsConfigurationSource corsConfig() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("*")); // 表示後端允許的 請求來源 有哪些
        config.setAllowedHeaders(List.of("*")); // 表示後端允許的 request header 有哪些
        config.setAllowedMethods(List.of("*")); // 表示後端允許的 http method 有哪些
//        config.setAllowCredentials(true); // 是否允許前端帶上cookie
        config.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }
}
