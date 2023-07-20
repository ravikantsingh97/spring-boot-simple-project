package com.jsp.simplespringboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.simplespringboot.dto.Product;
import com.jsp.simplespringboot.repository.ProductRepository;

@Repository
public class ProductDao {
	
	@Autowired
	ProductRepository productRepository;

	/*
	 * Insert Product method
	 */
	
	public Product  insertProduct(Product product)
	{
		return productRepository.save(product);
	}
	
	/*
	 * insert multiple product
	 */
	
	public List<Product> insertMultipleProducts(List<Product> products)
	{
		return productRepository.saveAll(products);
	}
	
	/*
	 * delete product
	 */
	
	public  void deleteProductByid(int productId)
	{
		Optional<Product> optional=productRepository.findById(productId);
		
		if(optional.isPresent())	
		{
			productRepository.delete(optional.get());
		}
	}
	
	
	/*
	 * get Product by Id
	 */
	
	public Product getProductById(int productId)
	{
		
		Optional<Product> optional=productRepository.findById(productId);
		if(optional.isPresent()) {
			return optional.get();
		}
		else
		{
			return null;
		}
		
		}
	
	/*
	 * get all product method
	 */
	
	public List<Product> getAllProduct()
	{
		return productRepository.findAll();
	}
		
	/*
	 * update by id
	 */
	
	public Product updateProductById(Product product)
	{
		Product product2=getProductById(product.getProductId());
		
		if(product2!=null)
		{
			product2.setProductName(product.getProductName());
			product2.setProductColor(product.getProductColor());
			product2.setProductPrice(product.getProductPrice());
			
			return productRepository.save(product2);
		}
		else
		{
			return null;
		}
	}
	
	
	}




