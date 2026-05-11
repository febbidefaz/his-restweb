package com.dev.generik.models.JadOp;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
//import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class JadOpResponseModel2 {
	
	private Long nomor;
	private Long id;
	private String tindakanId;
	private Long kelasId;
	private Long roomId;
	private String dokterId;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
	private Date tanggal; 
	
	@JsonFormat(shape = Shape.STRING, pattern = "HH:mm:ss", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.TIME)
	private Date jam;
	
	private String status;
	private String diagnosaId;
	private String ketDiag;
	private Long tempat;
	private Long klsStrgRen;
	private Long kelasIdRen;
	private Long roomIdRen;

  
}
