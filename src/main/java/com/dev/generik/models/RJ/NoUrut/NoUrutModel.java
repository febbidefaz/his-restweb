package com.dev.generik.models.RJ.NoUrut;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

//import com.dev.generik.bpjs.entities.SurgeryBooking;
@Getter
@Setter

public class NoUrutModel {
	 // Untuk QuePoli
    private Long quePoliId;
    private Long callNo;
    
    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
    private Date dayDate;
    
//    private LocalDateTime dayDate;
    private Long doctor;
    private Long id;
    private Long jamPraktek;
    private Boolean isLock;
    private String subLayanan;

    // Untuk Sensus
  //  private Long pxNo;
}  

