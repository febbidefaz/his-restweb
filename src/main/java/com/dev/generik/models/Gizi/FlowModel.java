package com.dev.generik.models.Gizi;


import java.util.List;

import com.dev.generik.entities.Gizi.Flow;
import com.dev.generik.entities.Gizi.FlowDet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlowModel {
	
	    private Flow flow;
	    private List<FlowDet> flowdet;

	    public FlowModel(Flow flow, List<FlowDet> flowdet) {
	        this.flow = flow;
	        this.flowdet = flowdet;
	    }

	    // Getters and setters

}
