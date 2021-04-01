package mx.com.gm.domain;

import lombok.Data;

@Data //anotación importada del proyecto Lombok (no es propio de Spring)
//para convertir una clase en una javabean
public class Persona {
    
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    
}
