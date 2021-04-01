package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data //anotación importada del proyecto Lombok (no es propio de Spring)
//para convertir una clase en una javabean
@Entity //convirtiendo la clase a una Entidad para ser usado por JPA
@Table(name = "rol") //especificando el nombre de la tabla de BD
public class Rol implements Serializable{
    
    private static final Long SerialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rol;
    
    @NotEmpty
    private String nombre;
    
}
