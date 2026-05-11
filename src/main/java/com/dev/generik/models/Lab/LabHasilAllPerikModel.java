package com.dev.generik.models.Lab;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter

public class LabHasilAllPerikModel {
	private Long id; 
	private Long prepID; 
	private String perik;	
	private String norL;
	private String levels;
	private String metode;
	private Long metodeID;	
	private Long biaya;
	private Long pot;
	private Float discount;  
}
