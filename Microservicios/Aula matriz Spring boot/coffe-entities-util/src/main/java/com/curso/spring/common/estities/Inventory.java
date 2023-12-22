package com.curso.spring.common.estities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TBL_INVENTORY")
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	private transient Store store;
	private transient RawProduct rawProduct;
	@Column(name = "QUANTITY")
	private Float quantity;

}
