package com.dev.generik.entities.RJ.NoUrut;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "QUEPOLI")
public class QuePoliN {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDQ")
    private Long idq;
    
    @Column(name = "CALL_NO")
    private Long callNo;
    
    @Column(name = "DAYDATE")
    private LocalDateTime dayDate;
    
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

