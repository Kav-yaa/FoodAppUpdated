package com.food.foodSpringApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.food.foodSpringApp.dao.ProductDao;
import com.food.foodSpringApp.dto.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
	ProductDao productDao;
    
    @PostMapping
	public Product saveProduct(@RequestBody Product product) {
		return productDao.saveProduct(product);
	}
	@GetMapping
	public List<Product> getAllProduct()
	{
		return productDao.getAllProduct();
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable int id)
	{  Optional<Product> op= productDao.getProductById(id);
	if(op.isEmpty())
	{
		return null;
	}
	else
	{
		return op.get();
	}
	}
	@PutMapping
	public Product updateCustomer(@RequestBody Product product)
	{
		return productDao.updateProduct(product);
	}
	
	@DeleteMapping
	public String deleteProduct(@RequestParam int id)
	{
		productDao.getProductById(id);
	Optional<Product>	op = productDao.getProductById(id);
	if (op.isPresent()) {
		productDao.deleteProduct(id);
		return "product id is deleted";
	} else {
    return "product is not found";
	}
	}
	
}
