package com.dev.generik.models.Lab;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter

public class LabHasilAllKatModel {
	
	private String kategori;
	private Long kateID;	
	
	private List<LabHasilAllPerikModel> periks;
	
}
