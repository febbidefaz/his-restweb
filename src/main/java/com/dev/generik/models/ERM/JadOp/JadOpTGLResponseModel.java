package com.dev.generik.models.ERM.JadOp;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
//import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class JadOpTGLResponseModel {
	
	private String tindakanId;
	private String dokterId;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
	private Date tanggal; 
	  
}
