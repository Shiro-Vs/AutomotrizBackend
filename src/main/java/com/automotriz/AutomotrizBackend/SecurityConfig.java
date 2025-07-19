package com.automotriz.AutomotrizBackend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .cors(Customizer.withDefaults()) // ✅ Habilita CORS
            .csrf(AbstractHttpConfigurer::disable) // ❌ Desactiva CSRF para desarrollo (no recomendado en producción)
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // ✅ Permite todo temporalmente
            );

        return http.build();
    }
}
