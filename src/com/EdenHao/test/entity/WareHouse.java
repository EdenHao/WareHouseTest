package com.EdenHao.test.entity;

import java.util.Map;

public class WareHouse {
	
	private String name;
	
	private Map<String, Product> products;
	
	private int priority;
	
	private int distance;
	
	public WareHouse() {
		// TODO Auto-generated constructor stub
	}

	public WareHouse(String name, Map<String, Product> products, int priority, int distance) {
		super();
		this.name = name;
		this.products = products;
		this.priority = priority;
		this.distance = distance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Product> getProducts() {
		return products;
	}

	public void setProducts(Map<String, Product> products) {
		this.products = products;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "WareHouse [name=" + name + ", products=" + products + ", priority=" + priority + ", distance="
				+ distance + "]";
	}

	
}
