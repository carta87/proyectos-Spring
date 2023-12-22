package com.curso.spring.common.estities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.curso.spring.common.constants.MessageStatus;

import lombok.Data;
@Data
@Entity
@Table(name = "TBL_NOTIFICATION_MESSAGE")
public class NotificationMessage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	private transient List<Customer> customers;
	@Column(name = "sentDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date sentDate;
	@Column(name = "MESSAGE")
	private transient MessageStatus message;
	@Column(name = "MESSAGE_STATUS")
	@Enumerated(EnumType.STRING)
	private transient MessageStatus messageStatus;

}
