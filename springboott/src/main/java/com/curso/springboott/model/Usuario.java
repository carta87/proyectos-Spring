package com.curso.springboott.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
@ToString @EqualsAndHashCode
public class Usuario {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "idusuarios")
    private Long id;

    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private String apellido;

    @Getter @Setter
    private String password;

    @Getter @Setter
    private String email;
}
