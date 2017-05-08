package com.niit.carmel.BackEnd;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.carmel.dao.CustomerDAO;
import com.niit.carmel.model.Cart;
import com.niit.carmel.model.Customer;

public class CustomerTestCase {
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	@Autowired
	static Customer customer;
	
	@Autowired
	static CustomerDAO customerDAO;
	
	/*@Autowired
	static Cart cart;
	*/

	@BeforeClass 
	public static void initailize()
	{
		customer=new Customer();
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.carmel");
		context.refresh();
		
		customerDAO=(CustomerDAO) context.getBean("customerDAO");
		 customer=context.getBean(Customer.class);
		 /*cart=context.getBean(Cart.class);*/
				
	}
	
	@Test
	public void insertTestCase()
	{
		customer.setId(1);
		customer.setFirstName("Carmelina");
		customer.setLastName("Fernando");
		customer.setEmail("fernando_carmelina@yahoo.in");
		customer.setPhoneNumber("9742147395");
		/*cart.setId(1);
		cart.setGrandTotal(10000);
		*/
		/*customer.setCart(cart);
	*/
		
		boolean flag=customerDAO.saveCustomer(customer);
		assertEquals("",true,flag);
	}
	
	

}
