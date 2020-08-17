package com.yetsdmr.foodsappproject.view.home;

import androidx.annotation.NonNull;

import com.yetsdmr.foodsappproject.Utils;
import com.yetsdmr.foodsappproject.model.Categories;
import com.yetsdmr.foodsappproject.model.Meals;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter {

    private HomeView view;

    public HomePresenter(HomeView view) {
        this.view = view;
    }

    void getMeals(){
        view.showLoading();

        Call<Meals> mealCall = Utils.getApi().getMeal();
        mealCall.enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(@NonNull Call<Meals> call, @NonNull Response<Meals> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body() != null){
                    view.setMeal(response.body().getMeals());
                }else {
                    view.onErrorLoading(response.message());
                }

            }

            @Override
            public void onFailure(@NonNull Call<Meals> call,@NonNull  Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }

    void getCategories(){
        view.showLoading();

        Call<Categories> categoriesCall = Utils.getApi().getCategories();
        categoriesCall.enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(@NonNull Call<Categories> call,@NonNull Response<Categories> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {

                    view.setCategory(response.body().getCategories());

                }
                else {
                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Categories> call, @NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}
