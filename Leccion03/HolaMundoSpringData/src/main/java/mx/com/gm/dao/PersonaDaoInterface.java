package mx.com.gm.dao;

import mx.com.gm.domain.Persona;
import org.springframework.data.repository.CrudRepository;

/*Para el acceso a datos se utiliza el concepto de repositorio, por medio
  de la implementación de la interfaz CrudRepository. Se especifica el tipo
  de la Entidad y el tipo de la llave primaria de la entidad*/

public interface PersonaDaoInterface extends CrudRepository<Persona, Long>{
    
    /*CrudRepository crea una implementación por defecto, pero si es necesario
    es posible agregar definiciones de métodos personalizados acá.*/
    
}
