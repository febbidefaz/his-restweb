package com.dev.generik.models.Resep;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResepOLTemplateModel {
	
		private Long id;
		private Long idDokter;
		private String nama;
		private Boolean approved;
		private Boolean racikan;
		private List<ObAtRspTemplateModel> obatList;
	    

}
