package com.dev.generik.entities.ERM.Billing;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
//@Table(name = "LAMA RAWAT INAP BPJS")
@Getter 
@Setter
public class Rek {
	 @Id	
	 @Column(name = "ID")
	 private Long id;
	 
	 @Column(name = "REGISTER")
	 private String register;
	 
	 @Column(name = "NAMA")
	 private String nama;
	 
	 @Column(name = "ADDR")
	 private String addr;
	 
	 @Column(name = "KELURAHAN")
	 private String kelurahan;
	 
	 @Column(name = "JENIS_KELAMIN")
	 private String jenisKelamin;	 
	
	 @Column(name = "TANGGAL_LAHIR")
	 private LocalDate tanggalLahir;	
	 
	 @Column(name = "KASIR")
	 private String kasir;
	 
	 @Column(name = "SHIFT")
	 private String shift;
	 
	 @Column(name = "TGLBYR")
	 private LocalDate tglbyr ;
	 
	 @Column(name = "PXRJ")
	 private Long pxrj;
	 
	 @Column(name = "TOTAL")
	 private Long total;
	 
}
