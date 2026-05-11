package com.dev.generik.models.Billing;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class RekRadiologiModel {
	 private Long idd;
	 private Long id;
	 private Long biayarad;
	 private LocalDate trad;
	 private Float discount;
	 private String periksa;	 
}
