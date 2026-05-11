package com.dev.generik.models.Lab;

import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class LabHasilAllModel {
	
	 private Long idd;
	 private String nama;
	 private String addr;
	 private String kelurahan;
	 private String jenisKelamin;
	 private LocalDate tanggalLahir;
	 private Long idReg;
	 private String regNum;
	 
	 private List<LabHasilAllIdLabModel> IdLab;
	 
	          
	   
}
