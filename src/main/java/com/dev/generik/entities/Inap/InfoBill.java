package com.dev.generik.entities.Inap;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "getBillPx", procedureName = "GetBillPx_sp", resultClasses = {
				InfoBill.class }, parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
						@StoredProcedureParameter(mode = ParameterMode.OUT, name = "biaya", type = Double.class),
						@StoredProcedureParameter(mode = ParameterMode.OUT, name = "namapx", type = String.class)

		}) })

public class InfoBill implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name = "NAMAPX")
	private String namapx;

	@Column(name = "TAGIHAN")
	private double biaya;

	private boolean flag;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNamapx() {
		return namapx;
	}

	public void setNamapx(String namapx) {
		this.namapx = namapx;
	}

	public double getBiaya() {
		return biaya;
	}

	public void setBiaya(double biaya) {
		this.biaya = biaya;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
