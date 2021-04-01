package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.PersonaDaoInterface;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*Cuando se trabaja con el modelo DAO se debe asegurar la transaccionalidad,
para ello en Spring se usa la anotación Transactional*/

//La anotación Service sirve para que Spring reconozca la clase como un Servicio
//Y no podríamos inyectar la clase dentro del controlador de Spring
@Service
public class PersonaServiceImplementacion implements PersonaService{

    @Autowired //injección de dependencias
    private PersonaDaoInterface personaDao; //DAO - Data Access Object - representa el modelo
    
    @Override
    @Transactional(readOnly = true) //definir transacción de solo lectura
    public List<Persona> listarPersona() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional //no se coloca parámetro, indica que será transaccional
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        return personaDao.findById(persona.getId_persona()).orElse(null);
    }
    
}
