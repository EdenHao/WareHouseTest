package com.EdenHao.test.entity;

public class Order {
	
	String prodName;
	
	int orderAmount;
	
	String wareName;

	public Order(String prodName, int orderAmount, String wareName) {
		super();
		this.prodName = prodName;
		this.orderAmount = orderAmount;
		this.wareName = wareName;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getWareName() {
		return wareName;
	}

	public void setWareName(String wareName) {
		this.wareName = wareName;
	}

	@Override
	public String toString() {
		return "Order [prodName=" + prodName + ", orderAmount=" + orderAmount + ", wareName=" + wareName + "]";
	}
	
	
}
