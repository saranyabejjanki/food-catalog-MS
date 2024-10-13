package com.sarulearn.foodcatalogue.service;

import com.sarulearn.foodcatalogue.dto.FoodCataloguePage;
import com.sarulearn.foodcatalogue.dto.FoodItemDTO;

public interface IFoodItemService {

    FoodItemDTO  saveFoodItem(FoodItemDTO foodItemDTO);

    FoodCataloguePage  fetchFoodItemAndRestaurantDetailsById(Integer restaurantId);
}
