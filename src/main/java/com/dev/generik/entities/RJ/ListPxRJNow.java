package com.dev.generik.entities.RJ;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "WSDAFTARPXRJ")
public class ListPxRJNow {

	@Id
	@Column(name = "ID2")
	private String id;

	@Column(name = "Rm", length = 10)
	private String rm;

	@Column(name = "Nama")
	private String nama;

	@Column(name = "Jp")
	private Long jp;

	@Column(name = "Idt")
	private Long idt;

	
}
