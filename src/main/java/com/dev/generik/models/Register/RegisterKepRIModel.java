package com.dev.generik.models.Register;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RegisterKepRIModel {
//	private Long no;
//	private Long id;		
	private String penerima;
	private String telp;
	
	public RegisterKepRIModel(//Long no, Long id, 
			String penerima, String telp) {
//		this.no = no;
//		this.id = id;						
		this.penerima = penerima;
		this.telp = telp;
	}
}
