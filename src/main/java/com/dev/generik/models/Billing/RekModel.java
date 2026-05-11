package com.dev.generik.models.Billing;

import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter

public class RekModel {
	 
	 private Long id;
	 private String register;
	 private String nama;
	 private String addr;
	 private String kelurahan;
	 private String jenisKelamin;	 
	 private LocalDate tanggalLahir;
	 private String kasir;
	 private String shift;
	 private LocalDate tglbyr;
	 private Long pxrj;
	 private Long total;
	 
	 private List<RekKamarBPJSModel> RekKamarBPJS;
	 private List<RekVisitModel> RekVisits;
	 private List<RekTindakanModel> RekTindakans;
	 private List<RekLaboratModel> RekLaborats;
	 private List<RekRadiologiModel> RekRadiologis;
	 private List<RekLainModel> RekLains;
	 private List<RekOperasiModel> RekOperasis;
	 private List<RekObatModel> RekObats;
	 
}
