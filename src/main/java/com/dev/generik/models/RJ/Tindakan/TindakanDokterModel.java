package com.dev.generik.models.RJ.Tindakan;
import java.sql.Date;
import java.time.LocalTime;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

//import com.dev.generik.bpjs.entities.SurgeryBooking;
@Getter
@Setter

public class TindakanDokterModel {
	private Long actID;
	private Long id;    
    private Long tindakID;
    
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    private Double biaya;
    private Double pot;
    
    @Temporal(TemporalType.TIME)
    private LocalTime  jam;
    private Long dokterID;
    private Long klasID;
    private Long roomID;
    private Boolean posted;
}  

