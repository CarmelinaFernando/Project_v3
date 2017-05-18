package com.niit.carmel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.niit.carmel.dao.CartDAO;
import com.niit.carmel.dao.CartItemDAO;
import com.niit.carmel.dao.CustomerDAO;
import com.niit.carmel.dao.ProductDAO;
import com.niit.carmel.model.Cart;
import com.niit.carmel.model.CartItems;
import com.niit.carmel.model.Customer;
import com.niit.carmel.model.Product;
import com.niit.carmel.model.Users;

@Controller
public class CartItemController {
	
	@Autowired
	private CartItemDAO cartItemDAO;
	@Autowired
	private CustomerDAO customerDAO;
	@Autowired 
	private ProductDAO productDAO;
	@Autowired
	private CartDAO cartDAO;
	
	@RequestMapping("/cart/addCartItem/{pid}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void addCartItem(@PathVariable(value="pid") int productId){
		
		Users users=(Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username=users.getUsername();
		Customer customer=customerDAO.getCustomerByUsername(username);//from Users where username=?
		Cart cart=customer.getCart();
		List<CartItems> cartItems=cart.getCartItems();
		
		Product product=productDAO.getProductData(productId);
		
		for(int i=0; i<cartItems.size();i++){
			CartItems cartItem=cartItems.get(i);
			Product p=cartItem.getProduct();
			//1==1
			
			if(p.getId()==productId){
				cartItem.setQuantity(cartItem.getQuantity()+1);//increment the quantity 
				cartItem.setTotalPrice(cartItem.getQuantity()*p.getPrice());//update the total price
				cartItemDAO.addCartItem(cartItem);//update the quantity in the cartItem
				return;
			}
		}
		
		CartItems cartItem=new CartItems();
		cartItem.setQuantity(1);
		cartItem.setTotalPrice(cartItem.getQuantity()* product.getPrice());
		cartItem.setProduct(product);//sets product id
		cartItem.setCart(cart);// sets cart id
		cartItemDAO.addCartItem(cartItem);//insert query
	}
	
	@RequestMapping("/cart/removeCartItem/{cartItemId}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void removeCartItem(@PathVariable int cartItemId){
		CartItems cartItems=cartItemDAO.getCartItem(cartItemId);
		cartItemDAO.addCartItem(cartItems);
		
	}
	
	@RequestMapping("/cart/removeAllCartItems/{cartId}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void removeAllCartItems(@PathVariable int cartId){
		Cart cart=cartDAO.getCart(cartId);
		cartItemDAO.removeAllCartItem(cart);
		
	}
	
	
	
	

}
