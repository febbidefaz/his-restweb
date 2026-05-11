package com.dev.generik.entities.RJ.Tindakan;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Data
@Entity
@Table(name = "Tindakan dokter")
//@IdClass(TindakanDokterId.class)
public class TindakanDokter {

    @Id
    

  //  @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long actID;
    
    private Long id;

  //  @Id
    private Long tindakID;

   // @Temporal(TemporalType.TIMESTAMP)
    @Temporal(TemporalType.DATE)
    private Date tanggal;

    private Double biaya;
    private Double pot;

  //  @Temporal(TemporalType.DATE)
    @Temporal(TemporalType.TIME)
    private LocalTime  jam;

    private Long dokterID;
    private Long klasID;
    private Long roomID;
    private Boolean posted;
}

