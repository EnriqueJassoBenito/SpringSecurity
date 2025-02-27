package utez.edu.mx.basicauth8d.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import utez.edu.mx.basicauth8d.security.filters.CustomFilter;

// BA04.- Crear la clase de configuracion para asegurar nuestro servicio
@EnableWebSecurity
@Configuration
public class MainSecurity {
    // Apartado para importar nuestros filtros, interceptores, repositorios, etc.
    @Autowired
    private CustomFilter customFilter;

    // Crear el objeto de configuracion de seguridad (FilterChain)
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable())
                .authorizeHttpRequests(auth -> auth
                        // BA07.- Crear las configuraciones de rutas
                        .requestMatchers("/api/test").permitAll()
                                .requestMatchers("/api/test/secured").hasRole("ADMIN")
                        .anyRequest().authenticated()
                        // BA05.- Crear el filtro de seguridad para aplicarlo a nuestro objeto
                ).addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class)
                /* <- Aui va los filtros (filtros after y before)*/;

        return http.build();
    }
}
// Siguiente -> Crear un endpoint/URI/ruta/path para probar las seguridad
