package com.ptzkg.mealsdrawer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ptzkg.mealsdrawer.R
import com.ptzkg.mealsdrawer.model.Meal
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_meal.view.*

class MealsAdapter(): RecyclerView.Adapter<MealsAdapter.MealsViewHolder>() {
    private var meals: List<Meal> = ArrayList()

    inner class MealsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private lateinit var meal: Meal

        fun bind(meal: Meal) {
            Picasso.get().load(meal.strMealThumb).placeholder(R.drawable.loading).into(itemView.imgMeal)
            itemView.txtMeal.text = meal.strMeal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealsViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_meal, parent,false)
        return MealsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return meals.size
    }

    override fun onBindViewHolder(holder: MealsViewHolder, position: Int) {
        holder.bind(meals[position])
    }

    fun updateMeals(meals: List<Meal>) {
        this.meals = meals
        notifyDataSetChanged()
    }
}