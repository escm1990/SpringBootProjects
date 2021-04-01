package mx.com.gm.web;

import lombok.extern.slf4j.Slf4j;
import mx.com.gm.servicio.PersonaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import mx.com.gm.domain.Persona;
import org.springframework.web.bind.annotation.PostMapping;


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
    
    @GetMapping("/agregar")
    /*No es necesario crear una instancia de Persona dentro del método, ya que
    basta con definirlo como un argumento más en el método, dentro de la fábrica
    de Spring se buscará un objeto de tipo persona y si no existe creará uno y 
    lo inyectará de manera automática en el método.*/
    public String agregar(Persona persona){
        //redirigiendo a la vista
        return "administrarPersona";
    }
    
    @PostMapping("/guardar")
    /*Spring recupera el objeto que se llenará del formulario, los nombres del
    objeto en el formulario y en el parámetro del método deben coincidir, para
    que Spring realice la inyección del objeto "persona"*/
    public String guardar(Persona persona){
        personaService.guardar(persona);
        return "redirect:/"; //redireccionando a la página de inicio
    }
 
    /*Cuando se utilizan parámetros en el path, el nombre de la variable debe
    ser exactamente igual al de la propiedad del objeto que se usará. Con el
    parámetro, Spring automáticamente va a asociar el valor del parámetro con
    el objeto (en este caso persona), es decir, que inicialzará el objeto 
    "persona" con el valor de "id_persona". No es necesaria la inicialización
    del objeto persona ni hacer set del valor de idPersona.
    La variable de modelo se compartirá en la siguiente petición.*/
    @GetMapping("/editar/{id_persona}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona",persona);
        return "administrarPersona";
    }
    
    @GetMapping("/eliminar")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
    
}
