package com.ptzkg.mealsdrawer.api

import com.ptzkg.mealsdrawer.model.Meals
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MealsApi {
    private lateinit var mealsApiInterface: MealsApiInterface

    companion object {
        const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
    }

    init {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        mealsApiInterface = retrofit.create(MealsApiInterface::class.java)
    }

    fun filterMeals(c: String): Call<Meals> {
        return mealsApiInterface.filterMeals(c)
    }
}