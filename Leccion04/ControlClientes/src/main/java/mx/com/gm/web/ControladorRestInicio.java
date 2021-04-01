package mx.com.gm.web;

import lombok.extern.slf4j.Slf4j;
import mx.com.gm.servicio.PersonaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

/*Para implementar SpringMVC, usamos la anotación @Controller*/
@Controller
/*Para el manejo de log*/
@Slf4j
public class ControladorRestInicio {
    
    //Injección de dependencias de la clase de servicio que maneja transaccionalidad
    @Autowired //símil de la anotación Inject de Java EE
    private PersonaService personaService;
    
    /*Para que el navegador interprete que este método,
     se debe ejecutar y se debe mapear a un path*/
    @GetMapping("/") //responde a localhost:8080
    public String inicio(Model model){
    
        var personas = personaService.listarPersona();
        log.info("Ejecutando el controlador de tipo Spring MVC");
        model.addAttribute("personas",personas);
        return "index"; 
    }
    
}
