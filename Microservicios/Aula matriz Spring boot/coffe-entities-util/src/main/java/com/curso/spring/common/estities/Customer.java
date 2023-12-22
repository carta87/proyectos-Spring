package com.curso.spring.common.estities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.curso.spring.common.constants.DocType;

import lombok.Data;

@Data
@Entity
@Table (name = "TBL_CUSTOMER")
public class Customer {
	
	@Id()
	@Column(name = "DOCUMENT_NUMBER")
	private String docNumber;
	@Column(name = "DOCUMENT_TYPE")
	private DocType docType;
	@Column(name = "fIRST_NAME")
	private String firstName;
	@Column(name = "lAST_NAM")
	private String lastNmae;
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	@Column(name = "EMAIL")
	private String email;
	private transient List<Sale> sales;
	private transient List<NotificationMessage> notificationMessages;
	

}
