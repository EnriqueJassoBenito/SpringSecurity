package utez.edu.mx.basicauth8d.modules.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

// BA06.- Crear las rutas para test de nuestra seguridad/filtros/interceptores
@RestController
@RequestMapping("/api/test")
@CrossOrigin(origins = "*")
public class TestController {
    @GetMapping("")
    public ResponseEntity<?> test() {
        Map<String, String> body = new HashMap<>();
        body.put("message", "Operacion exitosa");

        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> testSecured() {
        Map<String, String> body = new HashMap<>();
        body.put("message", "Operacion exitosa");

        return new ResponseEntity<>(body, HttpStatus.OK);
    }

}

// Siguiente -> Crear las configuraciones de ruta en MainSecurity