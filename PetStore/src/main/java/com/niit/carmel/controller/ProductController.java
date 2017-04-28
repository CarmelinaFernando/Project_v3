package com.niit.carmel.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.niit.carmel.dao.ProductDAO;
import com.niit.carmel.model.Product;

@Controller
public class ProductController {
	@Autowired
	ProductDAO prodDao;

	public ProductController() {
		System.out.println("Instantiating ProductController");

	}

	@RequestMapping("/admin/product/showProduct")

	public String showProduct(Model model) {
		model.addAttribute("product", new Product());
		return "addProductForm";

	}

	@RequestMapping("/admin/product/addProduct")

	public String addProduct(@ModelAttribute(value = "product") @Valid Product prod,BindingResult result) 
	{
		if (result.hasErrors()){
		
			return "addProductForm";
		}
		
		
		prodDao.insert(prod);
		
		
		MultipartFile prodImage=prod.getpImage();
		if (!prodImage.isEmpty()) {
			Path paths=
	Paths.get("C:\\Users\\Carmelina Fernando\\git\\Project_v2\\PetStore\\src\\main\\webapp\\resources\\images\\"+ prod.getId()+".png");
		try {
			prodImage.transferTo(new File(paths.toString()));
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		
		}
		 
		return "redirect:/all/product/getAllProduct";
	}

	@RequestMapping("/all/product/getAllProduct")
	public String displayAllProducts(Model model) {
		List<Product> prod = prodDao.retrieve();
		model.addAttribute("productlist", prod);
		return "productlist";
	}

	@RequestMapping("/admin/product/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id)

	{
		prodDao.delete(id);
		return "redirect:/all/product/getAllProduct";
	}

	@RequestMapping("/admin/product/viewProduct/{id}")
	public String viewProduct(@PathVariable int id, Model model)

	{
		Product p = prodDao.getProductData(id);
		model.addAttribute("product", p);
		return "viewProduct";
	}

}
