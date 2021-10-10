package com.kaldi.kaldiFruitsShop.representation;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FruitRepresentation<T> {
	private long code;

	@Length(max = 3)
	private T data;

	public FruitRepresentation() {
	}

	public FruitRepresentation(long code, T data) {
		this.code = code;
		this.data = data;
	}

	@JsonProperty
	public long getCode() {
		return code;
	}

	@JsonProperty
	public T getData() {
		return data;
	}

}
