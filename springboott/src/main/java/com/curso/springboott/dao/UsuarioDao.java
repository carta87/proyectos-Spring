package com.curso.springboott.dao;

import com.curso.springboott.model.Usuario;

import java.util.List;

public interface UsuarioDao {

    void eliminarUsuario(Long id);
    List<Usuario> getUsuarios();
    void registrarUsuario(Usuario usuario);

    boolean verificarDatosLogin(Usuario usuario);
}
