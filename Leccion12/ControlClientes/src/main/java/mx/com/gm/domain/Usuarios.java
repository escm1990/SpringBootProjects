package mx.com.gm.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data //anotación importada del proyecto Lombok (no es propio de Spring)
//para convertir una clase en una javabean
@Entity //convirtiendo la clase a una Entidad para ser usado por JPA
@Table(name = "usuarios") //especificando el nombre de la tabla de BD
public class Usuarios implements Serializable{
    
    private static final Long SerialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    
    @NotEmpty
    private String username;
    
    @NotEmpty
    private String password;
    
    /*
        Mapeo entre la clase usuarios con la clase rol.
        Un usuario puede tener múltiples roles (1->*)
    */
    @OneToMany
    @JoinColumn(name="id_usuario") //columna que está relacionando las tablas
    private List<Rol> roles;
}
