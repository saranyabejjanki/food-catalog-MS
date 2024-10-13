package com.sarulearn.foodcatalogue.dto;

import com.sarulearn.foodcatalogue.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCataloguePage {

    List<FoodItem> foodItems ;
    Restaurant restaurant;
}
