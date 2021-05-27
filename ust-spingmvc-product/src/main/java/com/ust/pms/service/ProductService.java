package com.ust.pms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.pms.model.Product;
import com.ust.pms.repository.ProductRepository;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	
	public void deleteProduct(Product product)
	{
	
		productRepository.delete(product);  
	}
	public void updateProduct(Product product)
	{
	
		productRepository.save(product);  
	}
	public void saveProduct(Product product)
	{
	
		productRepository.save(product);  
	}
	public List<Product> getProductDetails(){
		return (List<Product>) productRepository.findAll();
	}
	public Product getProduct(int productId) {
		Optional<Product> product= productRepository.findById(productId);
		return product.get();
	}
	
	public boolean isProductExist(int productId) {
		
		return productRepository.existsById(productId);
	}
	
public void deleteProductById(int productId) {
		
		 productRepository.deleteById(productId);
	}
}
