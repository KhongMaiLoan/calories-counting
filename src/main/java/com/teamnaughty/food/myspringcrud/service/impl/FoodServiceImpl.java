package com.teamnaughty.food.myspringcrud.service.impl;

import com.teamnaughty.food.myspringcrud.entity.Food;
import com.teamnaughty.food.myspringcrud.repository.FoodRepository;
import com.teamnaughty.food.myspringcrud.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired private FoodRepository foodRepository;

    @Override
    public List<Food> getAllFood(){
        return (List<Food>) foodRepository.findAll();
    }

    @Override
    public void saveFood(Food food){
        foodRepository.save(food);
    }

    @Override
    public void deleteFood(String  id){
        foodRepository.deleteById(id);
    }

    @Override
    public Optional<Food> findFoodById(String id){
        return foodRepository.findById(id);
    }

    @Override
    public List<Food> findFoodsByName(String name){
        List<Food> res = new ArrayList<>();
        List<Food> list = (List<Food>) foodRepository.findAll();
        for (Food food: list ) {
            if (food.getTen().toLowerCase().contains(name.toLowerCase())){
                res.add(food);
            }
        }
        return res;
    }
}
