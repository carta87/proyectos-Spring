package com.curso.spring.common.estities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TBL_PRODUCT")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	@Column(name = "NAME")
	private String name;
	private transient List<RawProduct> rawProducts;
	@Column(name = "UNIT_PRICE")
	private Float unitPrice;
	

}
