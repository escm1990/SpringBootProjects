package mx.com.gm.dao;

import mx.com.gm.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaDaoInterface extends JpaRepository<Persona, Long>{
    
}
