package com.dev.generik.models.Billing;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class RekObatModel {
	 private Long idd;
	 private Long id;
	 private LocalDate date;
	 private Float hutangobat;
}
