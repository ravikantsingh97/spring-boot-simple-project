package com.jsp.simplespringboot.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.simplespringboot.dao.ProductDao;
import com.jsp.simplespringboot.dto.Product;
import com.jsp.simplespringboot.response.ResponseStructure;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ResponseStructure<Product> responseStructure;
	

	/*
	 * Insert Product method
	 */
	
	public Product  insertProduct(Product product)
	{
		if(product.getProductPrice()<=40000)
		{
			return productDao.insertProduct(product);
		}
		else
		{
			return null;
		}
	}
	
	/*
	 * insert multiple product
	 */
	
	public List<Product> insertMultipleProducts(List<Product> products)
	{
		List<Product> products2 = new ArrayList<Product>();
		
		for (Product product : products) {
			if(product.getProductPrice()<=40000)
			{
				products2.add(product);
			}
		}
		return productDao.insertMultipleProducts(products2);
	}
	
	/*
	 * delete product
	 */
	
	public  ResponseStructure<Product> deleteProductByid(int productId)
	{
		Product product=productDao.getProductById(productId);
		
		if(product != null)
		{
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setDateTime(LocalDateTime.now());
			responseStructure.setStatusMessage("Success---------Data -Deleted");
			responseStructure.setDescription("com.springboot.simplespringboot.dto.Product");
			productDao.deleteProductByid(productId);
		}
		else
		{
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setDateTime(LocalDateTime.now());
			responseStructure.setStatusMessage("Data ----Not---Found");
			responseStructure.setDescription("com.springboot.simplespringboot.dto.Product");
		}
		
		return responseStructure;
		
	}
	
	/*
	 * get Product by Id
	 */
	
	public ResponseStructure<Product> getProductById(int productId)
	{
		Product product= productDao.getProductById(productId);
		if(product != null)
		{
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setDateTime(LocalDateTime.now());
			responseStructure.setStatusMessage("Success");
			responseStructure.setDescription("com.springboot.simplespringboot.dto.Product");
			responseStructure.setData(product);
		}
		else
		{
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setDateTime(LocalDateTime.now());
			responseStructure.setStatusMessage("Given----ID-----is----not----Present");
			responseStructure.setDescription("com.springboot.simplespringboot.dto.Product");
			responseStructure.setData(product);
		}
		
		return responseStructure;
	}
	
	/*
	 * get all product method
	 */
	
	public List<Product> getAllProduct()
	{
		return productDao.getAllProduct();
	}
	
	/*
	 * update by id
	 */
	
	public Product updateProductById(Product product)
	{
		return productDao.updateProductById(product);
	}
}
