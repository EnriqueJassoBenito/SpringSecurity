package utez.edu.mx.basicauth8d.kernel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

// BA03.- Crear nuestra configuracion de base de datos
@Configuration
public class DBConnection {
    // Traer las variables de mi application.properties
    @Value("${db.url}")
    private String DB_URL;

    @Value("${db.username}")
    private String DB_USERNAME;

    @Value("${db.password}")
    private String DB_PASSWORD;

    // Crear la conexion a la base de datos
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // 1.- Empieza como si fuera pagina WEB: com.mysql
        // 2.- GTA SA: cj
        // 3.- Protocolo de conexion: jdbc
        // 4.- Driver
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(DB_USERNAME);
        dataSource.setPassword(DB_PASSWORD);
        return dataSource;
    }
}
// Siguiente -> Crear la clase MainSecurity
