package com.dev.generik.models.Lab;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter

public class LabHasilAllIdLabModel {
	 private Long th;                  // umur (tahun)
	 private Long bln;                 // umur (bulan)
	 private Long hr;                  // umur (hari)	   
	 private String dokter;
	 private String kelas;
	 private Date jamAmbil;
	 private Long idlab;
	 private String rujukan;
	 private LocalDateTime tlab;
	 private String roomName;
	 private Date jamcheck;
	 private LocalDate tanggal;           // Therapy.Tanggal
	 private String note;                 // Metode.Note
	 private String usr;
	 private Boolean isok;
	 private String pxrs;
	 private String details;
	 
	 private List<LabHasilAllKatModel> kategoris;
}
