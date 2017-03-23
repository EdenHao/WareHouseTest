package com.EdenHao.test.generate_order;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.EdenHao.test.entity.Order;

public class TestOrderTest {

	@Test
	public void testGenerateOrder() {
	
		TestOrder to = new TestOrder();
		
		List<Order> generateOrder = to.generateOrder("B", 6);
		System.out.println("----ShipmentNumbers---ProductName---Number---ShipmentWarehouse");
		for(int i = 0; i < generateOrder.size(); i ++){
						
			System.out.println("	" + (i + 1) + "		" + generateOrder.get(i).getProdName() + "		" + generateOrder.get(i).getOrderAmount() + 
					"		" + generateOrder.get(i).getWareName());
		}
	}

}
