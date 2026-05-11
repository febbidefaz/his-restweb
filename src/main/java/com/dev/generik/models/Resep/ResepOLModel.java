package com.dev.generik.models.Resep;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResepOLModel {
	
		private Long id;
		@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
		@Temporal(TemporalType.DATE)
		private Date tgl;		
		@JsonFormat(shape = Shape.STRING, pattern = "HH:mm:ss", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
		@Temporal(TemporalType.TIME)
		private Date jam;
		private Long idReg;
		private Long idDokter;
		private Long kelasID;
		private Long roomID;
		private String manual;
		private Boolean racikan;
		private String ketInap;		
		private List<ObAtRspModel> obatList;
	    
/*	    private List<ResepOLMod> obAtRsps;
	    @Getter
	    @Setter
	    public static class ResepOLMod {	       
		    private Long id;
			private String kode;
			private Long qty;
			private Long signa;
	    
	    } */

}
