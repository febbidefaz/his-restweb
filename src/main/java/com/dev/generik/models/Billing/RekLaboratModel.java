package com.dev.generik.models.Billing;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class RekLaboratModel {
	 private Long idd;
	 private Long id;
	 private LocalDate tlab;
	 private Long biayalab;
	 private Float discount;	 
}
