package com.curso.java.curso.controllers;

import com.curso.java.curso.dao.UsuarioDao;
import com.curso.java.curso.models.Usuario;
import com.curso.java.curso.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.*;

@RestController
public class UsuarioController {

    @Autowired //injeccion de dependencia
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.GET)
    public Usuario crear(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Lucas");
        usuario.setApellido("Moy");
        usuario.setEmail("algo@algo.com");
        usuario.setTelefono("2342324234");

        return usuario;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(@RequestHeader(value = "Authorization") String token){

        if(!validarToken(token)){
            return null;
        }

        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario){

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024,1,usuario.getPassword());
        usuario.setPassword(hash);

        usuarioDao.registrar(usuario);
    }

    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.DELETE)
    public void eliminarUsuario(@RequestHeader(value = "Authorization") String token, @PathVariable Long id) {

        if(!validarToken(token)){return;}
        usuarioDao.eliminar(id);
    }

    private boolean validarToken(String token){
        String idUsuario = jwtUtil.getKey(token);
        return idUsuario != null;
    }

}
