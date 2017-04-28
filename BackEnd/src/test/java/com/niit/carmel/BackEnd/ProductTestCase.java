
package com.niit.carmel.BackEnd;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.carmel.dao.ProductDAO;

import com.niit.carmel.model.Product;

public class ProductTestCase {
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static Product product;
	
	@Autowired
	static ProductDAO productDAO; 
	
	@BeforeClass
	public static void initailize()
	{
		product=new Product();
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.carmel");
		context.refresh();
		
		productDAO=(ProductDAO) context.getBean("productDAO");
		
		product=context.getBean(Product.class);
		
	}
	
	@Test
	public void insertTestCase()
	{
		product.setId(2);
		product.setName("A Labrador");
		product.setDescription(" B belongs to dog");
		product.setPrice(50001);
		product.setQuantity(1);
		boolean flag=productDAO.insert(product);
		assertEquals("",true,flag);
	}
	
	
}
