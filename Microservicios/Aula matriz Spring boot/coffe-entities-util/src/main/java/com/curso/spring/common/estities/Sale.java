package com.curso.spring.common.estities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "TBL_SALE")
public class Sale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "CUSTOMER")
	private transient Customer customer;
	private transient List<Product> products;
	@Column (name = "SALE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@Column(name = "TOTAL_PRIECE")
	private Float totalPrice;
	@Column(name = "APPLID_DISCOUNT")
	private Float applidDiscount;

}
