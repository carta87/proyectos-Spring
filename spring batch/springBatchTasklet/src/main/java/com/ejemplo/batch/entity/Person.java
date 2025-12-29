package com.ejemplo.batch.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "personas")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lasName;
    private Integer age;
    private String insertionDate;
}
