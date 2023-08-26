package com.example.library.configurations;

import com.example.library.services.CustomUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@EnableWebSecurity
@RequiredArgsConstructor
@Configuration
public class SecurityConfig {
    private final CustomUserDetailService customUserDetailService;
    private final RestAuthEntryPoint restAuthEntryPoint;

    public static final String[] ENDPOINTS_WHITELIST = {
            "/",
            "/login/**",
            "/images/**",
            "/user/roles",
            "/registration",
            "/static/**",
            "/styles.css",
            "/bookcreate",
            "/css/**",
            "/book/**"
    };
    public static final String LOGIN_URL = "/login";
    public static final String LOGOUT_URL = "/logout";
    public static final String LOGIN_FAIL_URL = LOGIN_URL + "?error";
    public static final String DEFAULT_SUCCESS_URL = "/hello";
    public static final String HOMEPAGE_URL = "/";
    public static final String ADMIN_URL = "/admin";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//        http.csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth ->
//                        auth.
//                         requestMatchers(ADMIN_URL).hasRole("ADMIN")
//                        .requestMatchers(ENDPOINTS_WHITELIST).permitAll()
//                        .anyRequest().authenticated())
//                .formLogin(form -> form
//                        .loginPage(LOGIN_URL)
//                        .loginProcessingUrl(LOGIN_URL)
//                        .failureUrl(LOGIN_FAIL_URL)
//                        .usernameParameter(USERNAME)
//                        .passwordParameter(PASSWORD)
//                        .defaultSuccessUrl(HOMEPAGE_URL))
//                .logout(logout -> logout
//                        .permitAll()
//                );
                http.cors(cors -> {
                    try {
                        cors.init(http);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
                http
                        .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth ->
                        auth.
                         requestMatchers(ADMIN_URL).hasRole("ADMIN")
                        .requestMatchers(ENDPOINTS_WHITELIST).permitAll()
                        .anyRequest().authenticated())
                .exceptionHandling(hand -> hand.authenticationEntryPoint(restAuthEntryPoint))
                .formLogin(login -> login.loginProcessingUrl(LOGIN_URL).defaultSuccessUrl("/user/roles"))
                .logout(logout -> logout.logoutUrl("/logout")
                        .permitAll()
                );

        return  http.build();
    }
    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST", "OPTIONS", "OPTION"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
    }
}