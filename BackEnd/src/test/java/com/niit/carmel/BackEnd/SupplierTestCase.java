package com.niit.carmel.BackEnd;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.carmel.dao.SupplierDAO;
import com.niit.carmel.model.Supplier;

public class SupplierTestCase {
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static Supplier supplier;
	
	@Autowired
	static SupplierDAO supplierDAO; 
	
	@BeforeClass
	public static void initailize()
	{
		//supplier=new Supplier();
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.carmel");
		context.refresh();
		
		supplierDAO=(SupplierDAO) context.getBean("supplierDAO");
		
		supplier=context.getBean(Supplier.class);
		
	}
	
	@Test
	public void insertTestCase()
	{
		supplier.setId(1);
		supplier.setSupplierAddress("Elephant Road, Jayanagar 3rd Block");
		supplier.setSupplierName("R R Gold Place");
		
		boolean flag=supplierDAO.insert(supplier);
		assertEquals("",true,flag);
	}
	
/*	@Test
	public void deleteTestCase()
	{
//		int supplier=supplier.getId();
		boolean flag=supplierDAO.delete(supplier.getId(1));
		assertEquals("",true,flag);
		
	}
*/
}
