package com.dev.generik.models.Resep;

import java.util.List;
import com.dev.generik.entities.ERM.Resep.ObAtRspTemplateGet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResepOLTemplateGetResponseModel {
	
		private Long id;
		private Long idDokter;
		private String nama;
		private Boolean approved;
		private Boolean racikan;
		private List<ObAtRspTemplateGet> obatList;	

  
}
