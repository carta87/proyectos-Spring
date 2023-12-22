package com.curso.spring.common.estities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.curso.spring.common.constants.MeasusureUnit;
import lombok.Data;

@Data
@Entity
@Table(name = "TBL_RAW_PRODUCT")
public class RawProduct {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Short id;
 @Column(name = "NAME")
 private String name;
 private transient MeasusureUnit measusureUnit;
}
