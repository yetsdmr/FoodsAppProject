package com.yetsdmr.foodsappproject.view.category;

import com.yetsdmr.foodsappproject.model.Meals;

import java.util.List;

public interface CategoryView {
    void showLoading();
    void hideLoading();
    void setMeals(List<Meals.Meal> meals);
    void onErrorLoading(String message);
}
