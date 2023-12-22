package com.curso.springboott.controller;

import com.curso.springboott.dao.UsuarioDao;
import com.curso.springboott.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String loginUsuario(@RequestBody Usuario usuario){ //convertir el Json a usuario Automaticamente

      return usuarioDao.verificarDatosLogin(usuario) ? "OK" : "Fall";
    }
}
