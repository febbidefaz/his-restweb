package com.dev.generik.models.RJ;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponNoSEPModel {
	  private Long id;
	  private String noSEP;

	  public ResponNoSEPModel() {}

	 public ResponNoSEPModel(Long id, String noSEP) {
	      this.id = id;
	      this.noSEP = noSEP;
	 }

}
