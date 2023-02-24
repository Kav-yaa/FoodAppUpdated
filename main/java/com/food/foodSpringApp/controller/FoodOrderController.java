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

import com.food.foodSpringApp.dao.FoodOrderDao;
import com.food.foodSpringApp.dto.FoodOrder;



@RestController
@RequestMapping("/foodorders")
public class FoodOrderController {

	@Autowired
	FoodOrderDao foodorderDao;
	
	@PostMapping
	public FoodOrder saveData(@RequestBody FoodOrder foodorder)
	{
		 return foodorderDao.saveFoodOrder(foodorder);
	}
	
	@GetMapping
	public List<FoodOrder> getAllFoodOrder()
	{
		return foodorderDao.getAllFoodOrder();
	}
	
	@GetMapping("/{id}")
	public FoodOrder getFoodOrderById(@PathVariable int id)
	{  Optional<FoodOrder> op= foodorderDao.getFoodOrderById(id);
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
	public FoodOrder updateFoodOrder(@RequestBody FoodOrder foodorder)
	{
		return foodorderDao.updateFoodOrder(foodorder);
	}
	
	@DeleteMapping
	public String deleteFoodOrder(@RequestParam int id)
	{
		foodorderDao.getFoodOrderById(id);
	Optional<FoodOrder>	op = foodorderDao.getFoodOrderById(id);
	if (op.isPresent()) {
		foodorderDao.deteleFoodOrder(id);
		return "Food Order id is deleted";
	} else {
    return "Food order data is not found";
	}
	}
}
