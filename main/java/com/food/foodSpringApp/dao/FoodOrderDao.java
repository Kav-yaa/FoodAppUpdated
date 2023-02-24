package com.food.foodSpringApp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food.foodSpringApp.dto.FoodOrder;
import com.food.foodSpringApp.dto.Item;
import com.food.foodSpringApp.repository.FoodOrderRepo;
import com.food.foodSpringApp.repository.ItemRepo;

@Repository
public class FoodOrderDao {
     @Autowired
	FoodOrderRepo foodorderRepo;
     
     @Autowired
     ItemRepo itemRepo;
     
     public FoodOrder saveFoodOrder(FoodOrder foodorder)
     {
//    	 return foodorderRepo.save(foodorder);
//    	 next to get food order id for each list of items will follow below steps
    	 
    	 List<Item> listofItems = foodorder.getItems();
    	 List<Item> res = new ArrayList<>();
    	 if(listofItems.isEmpty())
    	 {
    		 foodorder = foodorderRepo.save(foodorder);
    	 } else {
    		 foodorder = foodorderRepo.save(foodorder);
    		 for(Item item : listofItems)  //iteration for list of items
    			 
    			 
    			 
    		 {
    			 item.setFoodorder(foodorder);
    			 res.add(itemRepo.save(item));
    		 }
    		 foodorder.setItems(res);
    	 }
    	 return foodorder;
     }
     
     public Optional<FoodOrder> getFoodOrderById(int id)
     {
		return foodorderRepo.findById(id);
     }
     
     public List<FoodOrder> getAllFoodOrder(){
		return foodorderRepo.findAll();
     }
     
     public FoodOrder updateFoodOrder(FoodOrder foodorder)
     {
		return foodorderRepo.save(foodorder); 
     }
     
     public void deteleFoodOrder(int id)
     {
    	 foodorderRepo.deleteById(id);
     }
     
}
