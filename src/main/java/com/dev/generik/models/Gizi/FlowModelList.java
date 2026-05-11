package com.dev.generik.models.Gizi;


import java.util.Date;
import java.util.List;

//import com.dev.generik.entities.Gizi.Flow;
import com.dev.generik.entities.Gizi.FlowDet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlowModelList {
	
	//    private Flow flow;
	    private Long id;
	    private Date flowTgl;
	    private Date jam;
	    private List<FlowDet> flowdet;

	    public FlowModelList(Long id, Date flowTgl, Date jam,List<FlowDet> flowdet) {
	        this.id = id;
	        this.flowTgl = flowTgl;
	        this.jam = jam;
	        this.flowdet = flowdet;
	    }

	    // Getters and setters
	/*    public Long GetId() {return id;}
	    public void SetId(Long id) {this.id = id;}
	    
	    public Date GetFlowTgl() {return flowTgl;}
	    public void SetFlowTgl(Date flowTgl) {this.flowTgl = flowTgl;}
	    
	    public Date GetJam() {return jam;}
	    public void SetJam(Date jam) {this.jam = jam;}  */
	    
}
