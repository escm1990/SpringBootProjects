package mx.com.gm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*Sping es un contenedor de clases.
 Para que Spring reconozca una clase debe estar dentro del paquete o subpaquete
 de la clase que contenga la anotación @SpringBootApplication*/
@RestController
/*Para el manejo de log*/
@Slf4j
public class ControladorRestInicio {
    
    /*Para que el navegador interprete que este método se debe ejecutar,
    se debe mapear a un path*/
    @GetMapping("/") //responde a localhost:8080
    public String inicio(){
        log.info("Ejecutando el controlador Rest");
        log.debug("Mas detalle del controlador...");
        return "Hola Mundo con Spring";
    }
    
}
