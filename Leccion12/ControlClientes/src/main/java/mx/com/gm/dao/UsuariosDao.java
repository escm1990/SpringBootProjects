package mx.com.gm.dao;

import mx.com.gm.domain.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosDao extends JpaRepository<Usuarios,Long>{
    Usuarios findByUsername(String username); //este método debe estar escrito tal cual, porque es requerido por SpringSecurity
}
