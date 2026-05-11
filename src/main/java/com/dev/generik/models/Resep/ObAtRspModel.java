package com.dev.generik.models.Resep;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ObAtRspModel {
	
  //  private Long id;
	private String kode;
	private Long qty;
	private Long signa;
	private String ket;
	private List<ContensTabModel> racikanList;

}
