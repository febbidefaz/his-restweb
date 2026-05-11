package com.dev.generik.models;

public class TB06IdModel {
	/**
	 * 
	 */
	// private static final long serialVersionUID = 12345L;

//	@NotNull	
//	@Size(min = 13, max=13)	
//	@Notnull
	private Long id;

	public TB06IdModel() {
		super();
	}

	/*
	 * public IdLabModel( Long id) { super(); this.id = id; }
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


}
