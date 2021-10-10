package com.kaldi.kaldiFruitsShop.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Fruit {
	private int id;
	@NotEmpty
	private String fruitName;
	@NotNull
	private Double quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Fruit() {
		super();
	}

	public Fruit(int id, String fruitName, Double quantitiy) {
		super();
		this.id = id;
		this.fruitName = fruitName;
		this.quantity = quantitiy;
	}
}
