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

import com.food.foodSpringApp.dao.CustomerDao;
import com.food.foodSpringApp.dto.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	CustomerDao customerDao;
	
	@PostMapping
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerDao.saveCustomer(customer);
	}
	@GetMapping
	public List<Customer> getAllCustomer()
	{
		return customerDao.getAllCustomer();
	}
	
//	@GetMapping("/{id}")
//	public Customer getCustomerById(@PathVariable int id)
//	{  Optional<Customer> op= customerDao.getCustomerById(id);
//	if(op.isEmpty())
//	{
//		return null;
//	}
//	else
//	{
//		return op.get();
//	}
//	}
	
	@PutMapping
	public Customer updateCustomer(@RequestBody Customer customer)
	{
		return customerDao.updateCustomer(customer);
	}
	
	@DeleteMapping
	public String deleteCustomer(@RequestParam int id)
	{
		customerDao.getCustomerById(id);
	Optional<Customer>	op = customerDao.getCustomerById(id);
	if (op.isPresent()) {
		customerDao.deleteCustomer(id);
		return "customer id is deleted";
	} else {
    return "customer is not found";
	}
	}
	
	@GetMapping("/{email}")
	public Customer getCustomerByEmail(@PathVariable String email) {
		return customerDao.getCustomerByEmail(email);
	}

}
