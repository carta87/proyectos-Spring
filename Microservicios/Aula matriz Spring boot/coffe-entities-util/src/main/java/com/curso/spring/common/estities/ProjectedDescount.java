package com.curso.spring.common.estities;

import java.util.Date;

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
@Table(name = "TBL_PROCEJECTED_DISCOUNT")
public class ProjectedDescount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	@Column(name = "CALC_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date calculationDate;
	@Column(name = "APPLY_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date applydate;
	@Column(name = "FORE_CAST_TEMPERATUE")
	private Float forecastTemperature;
	@Column(name = "DISCOUNT_PERCENTAGE")
	private Float discountPercentage;
	

}
