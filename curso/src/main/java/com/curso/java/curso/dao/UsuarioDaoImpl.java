package com.curso.java.curso.dao;

import com.curso.java.curso.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository //referencia a la conexión con la base de datos
@Transactional //hace referencia a que permitirá la transaccionalidad
public class UsuarioDaoImpl implements UsuarioDao{

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        return em.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Long id) {
        Usuario usuario =  em.find(Usuario.class, id);
        em.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario) {
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> lista = em.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        if(lista.isEmpty()){
            return null;
        }

        String passwordHashed =  lista.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        boolean passwordVerificado = argon2.verify(passwordHashed, usuario.getPassword());

        if(passwordVerificado){
            return lista.get(0);
        } else {
            return null;
        }
    }
}
