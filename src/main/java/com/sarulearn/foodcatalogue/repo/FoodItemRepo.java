package com.sarulearn.foodcatalogue.repo;

import com.sarulearn.foodcatalogue.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem,Integer> {
    List<FoodItem> findByRestaurantId(Integer restaurantId);
}
