package com.dev.generik.entities.RJ.NoUrut;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "QUEPOLI")
public class QuePoli {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDQ")
    private Long idq;
    
    @Column(name = "CALL_NO")
    private Long callNo;
    
    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
   	@Temporal(TemporalType.DATE)
    @Column(name = "DAYDATE")
    private Date dayDate;
    
    @Column(name = "DOCTOR")
    private Long doctor;
    
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "JAM_PRAKTEK")
    private Long jamPraktek;
    
    @Column(name = "IS_LOCK")
    private Boolean isLock;
    
    @Column(name = "SUBLAYANAN")
    private String subLayanan;
    
    
    // Getters and Setters
}

