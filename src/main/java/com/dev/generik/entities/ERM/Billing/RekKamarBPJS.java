package com.dev.generik.entities.ERM.Billing;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "LAMA RAWAT INAP BPJS")
@Getter 
@Setter
public class RekKamarBPJS {
	 @Id	
	 @Column(name = "NOMER")
	 private Long nomer;
	 
	 @Column(name = "ID")
	 private Long id;
	 
	 @Column(name = "KELASID")
	 private Long kelasid;
	 
	 @Column(name = "TMASUK")
	 private LocalDate tmasuk;
	 
	 @Column(name = "TKELUAR")
	 private LocalDate tkeluar;
	 
	 @Column(name = "LAMA")
	 private Float lama;
	 
	 @Column(name = "SEWA")
	 private Float sewa;
	 
	 @Column(name = "DISCOUNT")
	 private Float discount;
	 
	 @Column(name = "KELAS")
	 private String kelas;
	 
	 @Column(name = "ROOMNAME")
	 private String roomname;
	
	 
}
