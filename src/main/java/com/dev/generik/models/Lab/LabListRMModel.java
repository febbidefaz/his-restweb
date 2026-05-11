package com.dev.generik.models.Lab;


import java.util.Date;
import java.util.List;

public class LabListRMModel {
	  private Long id;
	    private Date tgl;
	    private String ket;
	    private String rm;
	    private List<LabListModel> listLab;

	    // Getter & Setter
	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public Date getTgl() { return tgl; }
	    public void setTgl(Date tgl) { this.tgl = tgl; }

	    public String getKet() { return ket; }
	    public void setKet(String ket) { this.ket = ket; }

	    public String getRm() { return rm; }
	    public void setRm(String rm) { this.rm = rm; }

	    public List<LabListModel> getListLab() { return listLab; }
	    public void setListLab(List<LabListModel> listLab) { this.listLab = listLab; }
}
