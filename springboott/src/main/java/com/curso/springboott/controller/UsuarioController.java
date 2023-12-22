package com.curso.springboott.controller;

import com.curso.springboott.dao.UsuarioDao;
import com.curso.springboott.model.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import de.mkammerer.argon2.jna.Argon2_type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired //la clase UsuarioDaoImp cree una instancia y la almacene en la variable usuarioDao ya que es mismo tipo
               //ademas al utilizarlo en varias partes de esta clase va estar compartido en memoria
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "usuarios/{id}", method = RequestMethod.GET)
    public void getUsuario(@PathVariable Long id){
        usuarioDao.eliminarUsuario(id);
    }

    @RequestMapping(value = "usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminarUsuario(@PathVariable Long id){
        usuarioDao.eliminarUsuario(id);
    }

    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuarios(){
        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario){ //convertir el Json a usuario Automaticamente

        Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d);
        String hash = argon2.hash(1,1024,1, usuario.getPassword());//1 parametro, 2memoria, 3varios procesos, texto- hast
        usuario.setPassword(hash);

         usuarioDao.registrarUsuario(usuario);
    }

    @RequestMapping(value = "usuario12")
    public Usuario editarUsuario(){
        Usuario user = new Usuario();
        user.setNombre("Carlos");
        user.setApellido("Tafur");
        user.setEmail("Cart_albert@hotmail.com");
        user.setPassword("123");
        return user;
    }


    @RequestMapping(value = "usuario234")
    public Usuario buscarUsuarios(){
        Usuario user = new Usuario();
        user.setNombre("Carlos");
        user.setApellido("Tafur");
        user.setEmail("Cart_albert@hotmail.com");
        user.setPassword("123");
        return user;
    }
}
