package com.teamnaughty.food.myspringcrud.service;

import com.teamnaughty.food.myspringcrud.entity.Food;

import java.util.List;
import java.util.Optional;

public interface FoodService {
    List<Food> getAllFood();
    void saveFood(Food food);
    void deleteFood(String id);
    Optional<Food> findFoodById(String id);
    List<Food> findFoodsByName(String name);
}
