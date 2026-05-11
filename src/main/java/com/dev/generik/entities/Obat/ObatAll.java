package com.dev.generik.entities.Obat;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Getter
@Setter

public class ObatAll {
	@Id	
	@Column(name = "IDD")
	private String idd;
	
	@Column(name = "IDREG")
    private Long idReg;
	
	@Column(name = "KODE")
    private String kode;
	
	@Column(name = "PRODUCTNAME")
    private String productName;
	
	@Column(name = "QTY")
    private Float qty;
	
	@Column(name = "DISCOUNT")
    private Float discount;
	
	@Column(name = "PRICE")
    private Float price;
	
	@Column(name = "INVOICEDATE")
    private LocalDateTime invoiceDate;
	
	@Column(name = "TOTALLINE")
    private Float totalLine;
	
	@Column(name = "ID")
    private Long id;
	
	@Column(name = "ROOMID")
    private Long roomID;
	
	@Column(name = "ROOMNAME")
    private String roomName;
	
	@Column(name = "TUNAI")
    private Float Tunai;
	
	@Column(name = "REGNUM")
    private String regNum;
	
	@Column(name = "NAMAPX")
    private String namaPx;
	
	@Column(name = "ADDR")
    private String addr;
    
    @Column(name = "KELURAHAN")
    private String kelurahan;
    
    @Column(name = "TANGGAL_LAHIR")
    private LocalDate tanggalLahir;
    
    @Column(name = "TELEPON")
    private String telepon;

  
}