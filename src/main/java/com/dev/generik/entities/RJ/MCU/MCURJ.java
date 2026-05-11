package com.dev.generik.entities.RJ.MCU;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "MCU")
@Getter
@Setter
@Data

public class MCURJ {

    @Id
 //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "Dokter")
	private Long dokter;
    
    @Column(name = "TANGGAL")
    private Date tanggal;
    
    @Column(name = "BERAT")
    private Double berat;
    
    @Column(name = "TINGGI")
    private Long tinggi;
    
    @Column(name = "SISTOLE")
    private Long sistole;
    
    @Column(name = "DIASTOLE")
    private Long diastole;
    
    @Column(name = "DENYUTNADI")
    private Long denyutNadi;
    
    @Column(name = "MATA")
    private Long mata;
    
    @Column(name = "MATAKET")
    private String mataKet;
    
    @Column(name = "MATAWARNA")
    private Long mataWarna;
    
    @Column(name = "MATAWARNAKET")
    private String mataWarnaKet;
    
    @Column(name = "HIDUNG")
    private String hidung;
    
    @Column(name = "MULUT")
    private String mulut;
    
    @Column(name = "TELINGA")
    private String telinga;
    
    @Column(name = "LEKENGETBENING")
    private String leKenGetBening;
    
    @Column(name = "LEKENGONDOK")
    private String leKenGondok;
    
    @Column(name = "DADAPARU")
    private String dadaParu;
    
    @Column(name = "DADAJANTUNG")
    private String dadaJantung;
    
    @Column(name = "REFLEKSENSIKUT")    
    private String reflekSenSikut;
    
    @Column(name = "REFLEKSENLUTUT")  
    private String reflekSenLutut;
    
    @Column(name = "LABORAT")  
    private String laborat;
    
    @Column(name = "RADIOLOGI")  
    private String radiologi;
    
    @Column(name = "ECGNEKG")  
    private String ecgNekg;
    
    @Column(name = "KESIMPULAN")  
    private String kesimpulan;
    
    @Column(name = "SARAN")  
    private String saran;
}
