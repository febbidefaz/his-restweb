package com.dev.generik.models;

import java.io.Serializable;

//default type T is Metadata.class 

public class ExLogModel<T> implements Serializable {

	private static final long serialVersionUID = 2649595519631053863L;
	private T metadata;

	public ExLogModel() {
		super();
	}

	public ExLogModel(T metadata) {
		super();
		this.metadata = metadata;
	}

	public T getMetadata() {
		return metadata;
	}

	public void setMetadata(T metadata) {
		this.metadata = metadata;
	}
}
