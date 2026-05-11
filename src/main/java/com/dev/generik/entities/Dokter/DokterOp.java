package com.dev.generik.entities.Dokter;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

//import java.util.Date;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

@Entity
@Table(name = "WSDOKTEROP")
@Getter
@Setter
public class DokterOp {
	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "DOKTER")
	private String dokter;
	
	@Column(name = "DOKTERALIAS")
	private String dokterOp;
	
	@Column(name = "KODE_DPJP")
	private String kdBPJS;
	
}
