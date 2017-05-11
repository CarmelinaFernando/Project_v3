package com.niit.carmel.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.niit.carmel.dao.CategoryDAO;
import com.niit.carmel.dao.ProductDAO;
import com.niit.carmel.model.Product;

@Controller
public class ProductController {
	@Autowired
	ProductDAO prodDao;
	
	@Autowired
	CategoryDAO categoryDAO;

	public ProductController() {
		System.out.println("Instantiating ProductController");

	}

	@RequestMapping("/admin/product/showProduct")

	public String showProduct(Model model) {
		model.addAttribute("productdata", new Product());
		model.addAttribute("productlist", prodDao.retrieve());
		model.addAttribute("categories", categoryDAO.getAllCategories());
		return "addProductForm";

	}

	@RequestMapping("/admin/product/addProduct")

	public String addProduct(@Valid @ModelAttribute(value = "productdata") Product product, BindingResult result,
			Model model,HttpServletRequest request) {
		if (result.hasErrors()) {
			//model.addAttribute("productlist", prodDao.retrieve());
			return "addProductForm";
		}
		

		prodDao.insert(product);

		MultipartFile file = product.getFile();
		/*if (!prodImage.isEmpty()) {
			Path paths = Paths
					.get("C:/Users/Carmelina Fernando/git/Project_v3/PetStore/src/main/webapp/resources/images/"
							+ prod.getId() + ".png");
			System.out.println(paths.toString());
			try {
				prodImage.transferTo(new File(paths.toString()));
				
			} catch (Exception e) {
				e.printStackTrace();

			}

		}*/
		if(file!=null && file.getSize()>0 )
		{
			String originalFile=file.getOriginalFilename();
			String filePath=request.getSession().getServletContext().getRealPath("/resources/images/productimages/");
			System.out.println(filePath + ""+originalFile);
			
			String myFileName= filePath + product.getId()+ ".jpg";
			try
			{
				byte imagebyte[]=product.getFile().getBytes(); // getting the byte form of the image
				BufferedOutputStream fos=new BufferedOutputStream(new FileOutputStream(myFileName));
				fos.write(imagebyte);
				fos.close();
				
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		

		return "redirect:/admin/product/showProduct";
	}

	@RequestMapping("/all/product/getAllProduct")
	public String displayAllProducts(Model model) {
		List<Product> prod = prodDao.retrieve();
		model.addAttribute("productlist", prod);
		/*List<Category> cat= catDao.getAllCategories();
		model.addAttribute("categorylist", cat);*/
		return "productlist";
	}

	@RequestMapping("/admin/product/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id,Model model)

	{
		model.addAttribute("productdata",new Product());
		prodDao.delete(id);
		return "addProductForm";
	}

	@RequestMapping("/admin/product/viewProduct/{id}")
	public String viewProduct(@PathVariable int id, Model model)

	{
		Product p = prodDao.getProductData(id);
		model.addAttribute("productdata", p);
		return "singleProductPage";
	}
	@RequestMapping("/admin/product/editProduct/{id}")
	public String editProduct(@PathVariable int id, @ModelAttribute("productdata") Product product,Model model)
	{
		 product = prodDao.getProductData(id);
		model.addAttribute("productdata",product);
		model.addAttribute("productlist",prodDao.retrieve());
		prodDao.updateProduct(product);
		return "addProductForm";
	}

}
