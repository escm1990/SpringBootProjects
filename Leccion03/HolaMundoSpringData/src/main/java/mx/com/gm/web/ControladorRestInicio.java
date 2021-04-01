package mx.com.gm.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.dao.PersonaDaoInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;

/*Para implementar SpringMVC, usamos la anotación @Controller*/
@Controller
/*Para el manejo de log*/
@Slf4j
public class ControladorRestInicio {
    
    //Injección de dependencias para la interfaz PersonaDAO
    @Autowired //símil de la anotación Inject de Java EE
    private PersonaDaoInterface personaDaoInterface;
    
    /*Para que el navegador interprete que este método,
     se debe ejecutar y se debe mapear a un path*/
    @GetMapping("/") //responde a localhost:8080
    public String inicio(Model model){
    
        var personas = personaDaoInterface.findAll();
        log.info("Ejecutando el controlador de tipo Spring MVC");
        model.addAttribute("personas",personas);
        return "index"; 
    }
    
}
