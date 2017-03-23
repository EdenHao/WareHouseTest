package com.EdenHao.test.generate_order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.EdenHao.test.entity.Order;
import com.EdenHao.test.entity.Product;
import com.EdenHao.test.entity.WareHouse;

/**
 * 	w1 warehouses have A goods only 1, B goods 2, C goods 2;
	w2 warehouses have A goods 2,B goods 1,C goods 2;
	w3 warehouses have A goods 1,B goods 3,C goods 1.
	In this one, the prices of each commodity in the warehouse are different.
	The distance of the addresses according to customer’s orders are w3=w2>w1.
	The priority of the warehouses is w1<w2<w3.
	
	distance: w3=w2=2    w1=1;
	priority: w1=1, w2=2, w3=3;
	
	
	w1--> w3--> w2
	
 * @author Administrator
 *
 */
public class TestOrder {
	
	private WareHouse w1;
	
	private WareHouse w2;
	
	private WareHouse w3;
	
	{
		w1 = new WareHouse();
		HashMap<String, Product> productW1 = new HashMap<>();
		w1.setName("w1");
		w1.setDistance(1);
		w1.setPriority(1);
		productW1.put("A", new Product("A", 1));
		productW1.put("B", new Product("B", 2));
		productW1.put("C", new Product("C", 2));
		w1.setProducts(productW1);
		
	    w2 = new WareHouse();
		HashMap<String, Product> productW2 = new HashMap<>();
		w2.setName("w2");
		w2.setDistance(2);
		w2.setPriority(2);
		productW2.put("A", new Product("A", 2));
		productW2.put("B", new Product("B", 1));
		productW2.put("C", new Product("C", 2));
		w2.setProducts(productW2);
		
	    w3 = new WareHouse();
		HashMap<String, Product> productW3 = new HashMap<>();
		w3.setName("w3");
		w3.setDistance(2);
		w3.setPriority(3);
		productW3.put("A", new Product("A", 1));
		productW3.put("B", new Product("B", 3));
		productW3.put("C", new Product("C", 1));
		w3.setProducts(productW3);
	}
	
	public TestOrder() {
				
	}

	/**
	 * 取货的原则: 先从最距离最近的仓库取货, 如果距离相同在按照仓库优先级取货
	 * 取货顺序为 : w1--> w3--> w2
	 * @param name
	 * @param amount
	 * @return
	 */
	public List generateOrder(String name, int amount){
		
		TestOrder testOrder = new TestOrder();
		
		List<Order> orders = new ArrayList<>();
		
		if("A".equals(name)){
			
			int amountW1A = w1.getProducts().get("A").getAmount();
			
			int amountW3A = w3.getProducts().get("A").getAmount();
			
			int amountW2A = w2.getProducts().get("A").getAmount();
			
			if(amount > amountW1A + amountW3A + amountW2A){
				
				System.out.println("amount are not enough !!");
				
			}else{
				
				if(amount <= amountW1A){
					
					orders.add(new Order("A", amount, "w1"));
					
				}else if(amount <= amountW1A + amountW3A){
					
					orders.add(new Order("A", amountW1A, "w1"));
					orders.add(new Order("A", amount - amountW1A, "w3"));
				}else{
					
					orders.add(new Order("A", amountW1A, "w1"));
					orders.add(new Order("A", amountW3A, "w3"));
					orders.add(new Order("A", amount -amountW3A - amountW1A, "w2"));
				}			
			}
			
			
		}
		
		if("B".equals(name)){
			
			int amountW1B = w1.getProducts().get("B").getAmount();
			
			int amountW3B = w3.getProducts().get("B").getAmount();
			
			int amountW2B = w2.getProducts().get("B").getAmount();
			
			if(amount > amountW1B + amountW3B + amountW2B){
				
				System.out.println("amount are not enough!!");
				
			}else{
				
				if(amount <= amountW1B){
					
					orders.add(new Order("B", amount, "w1"));
					
				}else if(amount <= amountW1B + amountW3B){
					
					orders.add(new Order("B", amountW1B, "w1"));
					orders.add(new Order("B", amount - amountW1B, "w3"));
				}else{
					
					orders.add(new Order("A", amountW1B, "w1"));
					orders.add(new Order("A", amountW3B, "w3"));
					orders.add(new Order("A", amount - amountW3B - amountW1B, "w2"));
				}			
				
			}
			
		}
		
		if("C".equals(name)){
			
			int amountW1C = w1.getProducts().get("C").getAmount();
			
			int amountW3C = w3.getProducts().get("C").getAmount();
			
			int amountW2C = w2.getProducts().get("C").getAmount();
			
			if(amount > amountW1C + amountW3C + amountW2C){
				
				System.out.println("amount are not enough!!");
			}else{
				
				if(amount <= amountW1C){
					
					orders.add(new Order("C", amount, "w1"));
					
				}else if(amount <= amountW1C + amountW3C){
					
					orders.add(new Order("C", amountW1C, "w1"));
					orders.add(new Order("C", amount - amountW1C, "w3"));
				}else{
					
					orders.add(new Order("C", amountW1C, "w1"));
					orders.add(new Order("C", amountW3C, "w3"));
					orders.add(new Order("C", amount -amountW3C - amountW1C, "w2"));
				}			
			}
			
			
		}
		
		return orders;
	} 
	
	public WareHouse getW1() {
		return w1;
	}



	public void setW1(WareHouse w1) {
		this.w1 = w1;
	}



	public WareHouse getW2() {
		return w2;
	}



	public void setW2(WareHouse w2) {
		this.w2 = w2;
	}



	public WareHouse getW3() {
		return w3;
	}



	public void setW3(WareHouse w3) {
		this.w3 = w3;
	}

}
