package com.cg.shopping.productservice.service;

import java.util.List;
import java.util.Optional;

import com.cg.shopping.productservice.entity.Product;

public interface ProductServicInterface {
	 public void addProduct(Product product);
	  public Product updateProduct(Product product);
	  public void deleteProductById(int productId);
	  public List<Product> getAllProducts();
	  public List<Product> getProductsByCategory(String category);
	  public List<Product> getProductsByProductType(String productType);
	  public Optional<Product> getProductById(int productId);
	  public Optional<Product> getProductByName(String productName);
	  public int getNextId();
	  

}
