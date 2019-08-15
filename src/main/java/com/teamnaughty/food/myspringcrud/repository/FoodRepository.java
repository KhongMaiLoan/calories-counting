package com.teamnaughty.food.myspringcrud.repository;

import com.teamnaughty.food.myspringcrud.entity.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends CrudRepository<Food, String> {

}
