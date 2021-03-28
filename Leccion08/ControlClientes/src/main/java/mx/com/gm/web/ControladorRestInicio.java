package mx.com.gm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import mx.com.gm.domain.Persona;

/*Para implementar SpringMVC, usamos la anotación @Controller*/
@Controller
/*Para el manejo de log*/
@Slf4j
public class ControladorRestInicio {
    
    //Accediendo al valor declarado en archivo de propiedades
    //por medio de injección de dependencias
    @Value("${index.saludo}")
    private String saludo; //con la anotación Value se injecta el valor de la clave-valor del archivo de properties
    
    /*Para que el navegador interprete que este método,
     se debe ejecutar y se debe mapear a un path*/
    @GetMapping("/") //responde a localhost:8080
    public String inicio(Model model){
        //A través del objeto Model vamos a compartir información con la vista
        var mensajeCompartir = "Hola mundo con Thymeleaf";
        
        var persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Perez");
        persona.setEmail("jp@correo.com");
        persona.setTelefono("55443322");
        
        var persona2 = new Persona();
        persona2.setNombre("Maria");
        persona2.setApellido("Luisa");
        persona2.setEmail("ml@correo.com");
        persona2.setTelefono("11223344");
        
//        List<Persona> personas = new ArrayList();
//        personas.add(persona);
//        personas.add(persona2);
        
        //otra forma de crear arreglo de personas
        var personas = Arrays.asList(persona, persona2);

        log.info("Ejecutando el controlador de tipo Spring MVC");
        model.addAttribute("mensaje",mensajeCompartir);
        model.addAttribute("saludo",saludo);
        model.addAttribute("persona",persona);
        model.addAttribute("personas",personas);
        return "index"; 
    }
    
}
