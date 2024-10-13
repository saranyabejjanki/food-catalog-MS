package com.sarulearn.foodcatalogue.service;

import com.sarulearn.foodcatalogue.dto.FoodCataloguePage;
import com.sarulearn.foodcatalogue.dto.FoodItemDTO;
import com.sarulearn.foodcatalogue.dto.Restaurant;
import com.sarulearn.foodcatalogue.entity.FoodItem;
import com.sarulearn.foodcatalogue.mapper.FoodItemMapper;
import com.sarulearn.foodcatalogue.repo.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class FoodItemService implements  IFoodItemService {

    @Autowired
    FoodItemRepo foodItemRepo;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public FoodItemDTO saveFoodItem(FoodItemDTO foodItemDTO) {
        FoodItem foodItem = FoodItemMapper.FOOD_ITEM_MAPPER.mapFoodItemDTOToFoodItem(foodItemDTO);
        FoodItem savedFoodItem = foodItemRepo.save(foodItem);
        FoodItemDTO foodItemDTOObject = null;
        if (Objects.nonNull(savedFoodItem)) {
            foodItemDTOObject = FoodItemMapper.FOOD_ITEM_MAPPER.mapFoodItemToFoodItemDTO(savedFoodItem);
        }
        return foodItemDTOObject;
    }

    @Override
    public FoodCataloguePage fetchFoodItemAndRestaurantDetailsById(Integer restaurantId) {

        Restaurant restaurant =fetchRestaurantDetailsFromRestaurantMS(restaurantId);

        List<FoodItem> foodItems= fetchFoodItemDetailsByRestaurantId(restaurantId);

        FoodCataloguePage foodCataloguePage=createFoodCataloguePage(foodItems,restaurant);

        return foodCataloguePage;
    }

    private List<FoodItem> fetchFoodItemDetailsByRestaurantId(Integer restaurantId) {

        List<FoodItem> foodItems = foodItemRepo.findByRestaurantId(restaurantId);
        return foodItems;
    }

    private Restaurant fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
        Restaurant restaurant =  restTemplate.getForObject("http://RESTAURANT-SERVICE/api/restaurant/"+restaurantId,Restaurant.class);
        return  restaurant;
    }

    private  FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItems,Restaurant restaurant){

        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setFoodItems(foodItems);
        foodCataloguePage.setRestaurant(restaurant);

        return  foodCataloguePage;
    }
}
