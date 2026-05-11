package com.dev.generik.models.Gizi;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlowModelView {
	    private Long id;
	    private Date flowTgl;
	    private Date jam;
	    private List<FlowDetModelView> flowDets;

	    public FlowModelView(Long id, Date flowTgl, Date jam, List<FlowDetModelView> flowDets) {
	        this.id = id;
	        this.flowTgl = flowTgl;
	        this.jam = jam;
	        this.flowDets = flowDets;
	    }
}
