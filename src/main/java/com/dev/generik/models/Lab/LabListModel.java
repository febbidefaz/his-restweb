package com.dev.generik.models.Lab;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LabListModel {
	
	 private Long idlab;
	 private Long idreg;
	 private Date tlab;
	 
	 public Long getIdlab() { return idlab; }
	 public void setIdlab(Long idlab) { this.idlab = idlab; }

	public Long getIdreg() { return idreg; }
	public void setIdreg(Long idreg) { this.idreg = idreg; }

	public Date getTlab() { return tlab; }
	public void setTlab(Date tlab) { this.tlab = tlab; }
}
