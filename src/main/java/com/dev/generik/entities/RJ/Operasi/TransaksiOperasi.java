package com.dev.generik.entities.RJ.Operasi;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

@Data
@Table(name = "Transaksi Operasi")
public class TransaksiOperasi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPE_ID")
    private Integer opeID;

    @Column(name = "ID")
    private Integer id;
    
    @Column(name = "JENISOP")
    private Integer jenisOp;
    
    @Column(name = "TGOP")
    private Date tgOp;
    
    @Column(name = "STARTOP")
    private Date startOp;
    
    @Column(name = "ENDOP")
    private Date endOp;
    
    @Column(name = "OP")
    private String op;
    
    @Column(name = "ASS")
    private String ass;
    
    @Column(name = "ANES")
    private String anes;
    
    @Column(name = "ASSANES")
    private String assAnes;
    
    @Column(name = "BIAYAOP")
    private Double biayaOp;
    
    @Column(name = "BIAYAANES")
    private Double biayaAnes;
    
    @Column(name = "BIAYAASS")
    private Double biayaAss;
    
    @Column(name = "BIAYAASSANES")
    private Double biayaAssAnes;
    
    @Column(name = "SEWAALAT")
    private Double sewaAlat;
    
    @Column(name = "BAHAN")
    private Double bahan;
    
    @Column(name = "SEWAOK")
    private Double sewaOK;
    
    @Column(name = "JASA")
    private Double jasa;
    
    @Column(name = "CSSD")
    private Double cssd;

    @Column(name = "POTOP")
    private Double potOp;
    
    @Column(name = "POTASS")
    private Double potAss;
    
    @Column(name = "POTANES")
    private Double potAnes;
    
    @Column(name = "POTASSANES")
    private Double potAssAnes;
    
    @Column(name = "POTALAT")
    private Double potAlat;
    
    @Column(name = "POTBAHAN")
    private Double potBahan;
    
    @Column(name = "POTOK")
    private Double potOk;
    
    @Column(name = "POTJASA")
    private Double potJasa;

    @Column(name = "KLASID")
    private Integer klasID;
    
    @Column(name = "ROOMID")
    private Integer roomID;
    
    @Column(name = "ATOK")
    private Boolean atOk;
    
    @Column(name = "USR")
    private String usr;
    
    @Column(name = "PROSENOP")
    private Double prosenOp;
    
    @Column(name = "PROSENASS")
    private Double prosenAss;
    
    @Column(name = "PROSENANES")
    private Double prosenAnes;
    
    @Column(name = "PROSENASSANES")
    private Double prosenAssAnes;
    
    @Column(name = "PROSENALAT")
    private Double prosenAlat;
    
    @Column(name = "PROSENBAHAN")
    private Double prosenBahan;
    
    @Column(name = "PROSENOK")
    private Double prosenOk;
    
    @Column(name = "PROSENJASA")
    private Double prosenJasa;

    @Column(name = "NOTE")
    private String note;
    
    @Column(name = "POSTED")
    private Boolean posted;
}
