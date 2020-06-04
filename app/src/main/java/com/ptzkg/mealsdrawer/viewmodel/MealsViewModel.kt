package com.ptzkg.mealsdrawer.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ptzkg.mealsdrawer.api.MealsApi
import com.ptzkg.mealsdrawer.model.Meal
import com.ptzkg.mealsdrawer.model.Meals
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsViewModel: ViewModel() {
    val meals: MutableLiveData<List<Meal>> = MutableLiveData()
    private val mealsApi: MealsApi = MealsApi()

    fun getMeals(): LiveData<List<Meal>> = meals

    fun loadMeals(c: String) {
        Log.d("MealsViewModel>>>>", "loadMeals")
        val call = mealsApi.filterMeals(c)

        call.enqueue(object: Callback<Meals> {
            override fun onFailure(call: Call<Meals>, t: Throwable) {
                Log.d("MealsViewMoel>>>>", t.toString())
            }

            override fun onResponse(call: Call<Meals>, response: Response<Meals>) {
                response.isSuccessful.let {
                    Log.d("MealsViewModel>>>>", "onResponse")
                    meals.value = response.body()?.meals
                }
            }

        })

    }
}