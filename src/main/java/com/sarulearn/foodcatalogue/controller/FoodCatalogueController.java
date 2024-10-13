package com.sarulearn.foodcatalogue.controller;

import com.sarulearn.foodcatalogue.dto.FoodCataloguePage;
import com.sarulearn.foodcatalogue.dto.FoodItemDTO;
import com.sarulearn.foodcatalogue.entity.FoodItem;
import com.sarulearn.foodcatalogue.service.FoodItemService;
import com.sarulearn.foodcatalogue.service.IFoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(value="/foodCatalogue")
public class FoodCatalogueController {

    @Autowired
    IFoodItemService foodItemService;

    @PostMapping(path ="/saveFoodItem")
    public ResponseEntity<FoodItemDTO> saveFoodItem(@RequestBody FoodItemDTO foodItemDTO){
        FoodItemDTO  savedFoodItemDTO =foodItemService.saveFoodItem(foodItemDTO);
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        if(Objects.nonNull(savedFoodItemDTO)){
            httpStatus = HttpStatus.CREATED;
        }
        return new ResponseEntity<>(savedFoodItemDTO,httpStatus);
    }

    @GetMapping(path="/fetchFoodAndRestaurantById/{restaurantId}")
    public ResponseEntity<FoodCataloguePage> fetchFoodItemAndRestaurantDetailsById(@PathVariable  Integer restaurantId){

        FoodCataloguePage foodCataloguePage =foodItemService.fetchFoodItemAndRestaurantDetailsById(restaurantId);
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        if(Objects.nonNull(foodCataloguePage)){
            httpStatus = HttpStatus.OK;
        }
        return new ResponseEntity<>(foodCataloguePage,httpStatus);
    }
}
