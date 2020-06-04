package com.ptzkg.mealsdrawer.api

import com.ptzkg.mealsdrawer.model.Meals
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsApiInterface {

    @GET("filter.php")
    fun filterMeals(
        @Query("c") c: String
    ): Call<Meals>
}