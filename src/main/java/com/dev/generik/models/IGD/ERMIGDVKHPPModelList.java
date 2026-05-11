package com.dev.generik.models.IGD;

import java.util.Date;
import java.util.List;

import com.dev.generik.entities.ERM.IGD.SkriningHPPVK.ERMIGDVKHPPDet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ERMIGDVKHPPModelList {
	
	//    private Flow flow;
	    private Long id;
	    private Date tanggal;
	    private Long kel;
	    private List<ERMIGDVKHPPDet> eRMIGDVKHPPDet;

	    public ERMIGDVKHPPModelList(Long id, Date tanggal, Long kel, List<ERMIGDVKHPPDet> eRMIGDVKHPPDet) {
	        this.id = id;
	        this.tanggal = tanggal;
	        this.kel = kel;
	        this.eRMIGDVKHPPDet = eRMIGDVKHPPDet;
	    }

	    // Getters and setters
	/*    public Long GetId() {return id;}
	    public void SetId(Long id) {this.id = id;}
	    
	    public Date GetFlowTgl() {return flowTgl;}
	    public void SetFlowTgl(Date flowTgl) {this.flowTgl = flowTgl;}
	    
	    public Date GetJam() {return jam;}
	    public void SetJam(Date jam) {this.jam = jam;}  */
	    
}
