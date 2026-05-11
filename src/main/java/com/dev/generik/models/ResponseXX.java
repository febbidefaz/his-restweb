package com.dev.generik.models;

import java.io.Serializable;

public class ResponseXX<T, V> implements Serializable {
	private static final long serialVersionUID = 6207095374509215028L;

	private T response;
	private V metadata;

	public ResponseXX() {
		super();
	}

	public ResponseXX(T response, V metadata) {
//		super();
		this.response = response;
		this.metadata = metadata;
	}

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}

	public V getMetadata() {
		return metadata;
	}

	public void setMetadata(V metadata) {
		this.metadata = metadata;
	}
}
