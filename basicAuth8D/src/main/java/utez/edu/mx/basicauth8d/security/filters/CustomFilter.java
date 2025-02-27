package utez.edu.mx.basicauth8d.security.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class CustomFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Este bloque se ejecutara ANTES del filtro
        System.out.println("Metodo de la solicitud: " + request.getMethod());
        System.out.println("Ruta a la que se quiere acceder: " + request.getRequestURI());

        // Ejecucion del filtro
        filterChain.doFilter(request, response);

        // Este bloque se ejecuta DESPUES del filtro (Este puede o NO ejecutarse)
        System.out.println("Finalizacion del CustomFilter");
    }
}
