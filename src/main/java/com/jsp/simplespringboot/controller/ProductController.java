package com.jsp.simplespringboot.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.jsp.simplespringboot.dto.Product;
import com.jsp.simplespringboot.response.ResponseStructure;
import com.jsp.simplespringboot.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService  productService;
	
	
   @GetMapping(value = "/getMyData")
	public String getData()
	{
		return "Good Morning India";
	}

   /*
	 * Insert Product method
	 */
	@PostMapping(value = "/insertProduct")
	public Product  insertProduct(@RequestBody Product product)
	{
		return productService.insertProduct(product);
	}
	
	/*
	 * insert multiple product
	 */
	@PostMapping(value = "/insertMultipleProducts")
	public List<Product> insertMultipleProducts(@RequestBody List<Product> products)
	{
		return productService.insertMultipleProducts(products);
	}
		

	/*
	 * delete product
	 */
	@DeleteMapping(value = "/deleteProduct/{productId}")
	public  ResponseStructure<Product>  deleteProductByid(@PathVariable int productId)
	{
		return productService.deleteProductByid(productId);
	}
	
	/*
	 * get Product by Id
	 */
	@GetMapping(value = "/getProductById/{productId}")
	public ResponseStructure<Product> getProductById(@PathVariable int productId)
	{
		return productService.getProductById(productId);
	}
		
	/*
	 * get all product method
	 */
	
	@GetMapping(value = "/getAllProduct")
	public List<Product> getAllProduct()
	{
		return productService.getAllProduct();
	}
		
	/*
	 * update by id
	 */
	@PutMapping("/updateProduct")
	public Product updateProductById(@RequestBody Product product)
	{
		return productService.updateProductById(product);
	}
}

