package com.curso.java.curso.controllers;

import com.curso.java.curso.dao.UsuarioDao;
import com.curso.java.curso.models.Usuario;
import com.curso.java.curso.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired //injeccion de dependencia
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String iniciarSesion(@RequestBody Usuario usuario){

        Usuario usuarioObtenido = usuarioDao.obtenerUsuarioPorCredenciales(usuario);

        if(usuarioObtenido != null){
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioObtenido.getId()), usuarioObtenido.getEmail());
            return tokenJwt;
        } else{
            return "FAIL";
        }

    }

}
