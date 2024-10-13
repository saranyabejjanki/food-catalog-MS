package com.sarulearn.foodcatalogue.mapper;

import com.sarulearn.foodcatalogue.dto.FoodItemDTO;
import com.sarulearn.foodcatalogue.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {
      FoodItemMapper FOOD_ITEM_MAPPER = Mappers.getMapper(FoodItemMapper.class);

//        FoodItemDTO mapFoodItemToFoodItemDTO(FoodItem foodItem);
//        FoodItem  mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO);

         FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO);
         FoodItemDTO mapFoodItemToFoodItemDTO(FoodItem foodItem);

}
