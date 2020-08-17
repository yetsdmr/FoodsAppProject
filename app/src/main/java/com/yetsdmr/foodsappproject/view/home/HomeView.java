package com.yetsdmr.foodsappproject.view.home;

import com.yetsdmr.foodsappproject.model.Categories;
import com.yetsdmr.foodsappproject.model.Meals;

import java.util.List;

public interface HomeView {
    void showLoading();
    void hideLoading();
    void setMeal(List<Meals.Meal> meal);
    void setCategory(List<Categories.Category> category);
    void onErrorLoading(String message);
}
