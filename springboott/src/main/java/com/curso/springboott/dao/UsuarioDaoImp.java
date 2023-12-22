package com.curso.springboott.dao;

import com.curso.springboott.model.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository  //conexion a la base de datos
@Transactional //se encarga de armar las setencias SQL a BD
public class UsuarioDaoImp implements UsuarioDao{

    @PersistenceContext
    EntityManager entityManager;//para realizar la conexion BD

    @Override
    public List<Usuario> getUsuarios() {
        String sql = "from Usuario";
        List<Usuario> usuarios = new ArrayList<>();

        usuarios = entityManager.createQuery(sql).getResultList();
         return usuarios;
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        entityManager.merge(usuario);

    }

    @Override
    public boolean verificarDatosLogin(Usuario usuario) {
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter( "email", usuario.getEmail())
                .getResultList();
        System.out.println("por antes");
        if(lista.isEmpty()) {return false;} else{
            System.out.println("por aqui");
        }

        String passwordHashed= lista.get(0).getPassword();
        System.out.println( "valor de la lista " +passwordHashed);
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String valor =  argon2.toString();
        System.out.println( "valor de la lista " +valor);
        return argon2.verify(passwordHashed, usuario.getPassword());
    }

    @Override
    public void eliminarUsuario(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);

    }
}

