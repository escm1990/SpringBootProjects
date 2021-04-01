package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Data;


@Data //anotación importada del proyecto Lombok (no es propio de Spring)
//para convertir una clase en una javabean
@Entity //convirtiendo la clase a una Entidad para ser usado por JPA
@Table(name = "persona") //especificando el nombre de la tabla de BD
public class Persona implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    /*Mapeando llave primaria autoincrementable*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_persona;
    
    @NotEmpty //Para cadenas se recomienda NotEmpty, pues NotNull no valida cadenas vacías    
    private String nombre;
    
    @NotEmpty
    private String apellido;
    
    @NotEmpty
    @Email //validar email para campos de texto
    private String email;

    private String telefono;
    
}
