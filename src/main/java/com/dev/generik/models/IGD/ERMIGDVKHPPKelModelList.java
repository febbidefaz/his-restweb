package com.dev.generik.models.IGD;

import java.util.List;
import com.dev.generik.entities.ERM.IGD.SkriningHPPVK.ERMIGDVKHPPNama;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ERMIGDVKHPPKelModelList {
	
	//    private Flow flow;
	    private Long id;
	    private String nama;
	    private String ket;
	    private String kat;
	    private List<ERMIGDVKHPPNama> eRMIGDVKHPPNama;

	    public ERMIGDVKHPPKelModelList(Long id, String nama, String ket, String kat, List<ERMIGDVKHPPNama> eRMIGDVKHPPNama) {
	        this.id = id;
	        this.nama = nama;
	        this.ket = ket;
	        this.kat = kat;
	        this.eRMIGDVKHPPNama = eRMIGDVKHPPNama;
	    }

	    // Getters and setters
	/*    public Long GetId() {return id;}
	    public void SetId(Long id) {this.id = id;}
	    
	    public Date GetFlowTgl() {return flowTgl;}
	    public void SetFlowTgl(Date flowTgl) {this.flowTgl = flowTgl;}
	    
	    public Date GetJam() {return jam;}
	    public void SetJam(Date jam) {this.jam = jam;}  */
	    
}
