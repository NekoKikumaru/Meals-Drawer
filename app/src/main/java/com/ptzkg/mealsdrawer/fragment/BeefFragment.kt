package com.ptzkg.mealsdrawer.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ptzkg.mealsdrawer.R
import com.ptzkg.mealsdrawer.adapter.MealsAdapter
import com.ptzkg.mealsdrawer.viewmodel.MealsViewModel
import kotlinx.android.synthetic.main.fragment_beef.*
import kotlinx.android.synthetic.main.fragment_chicken.*

class BeefFragment : Fragment() {
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var beefAdapter: MealsAdapter
    private lateinit var viewModel: MealsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beef, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layoutManager = LinearLayoutManager(context)
        beefAdapter = MealsAdapter()
        recyclerBeef.adapter = beefAdapter
        recyclerBeef.layoutManager = layoutManager
        observeViewModel()
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadMeals("beef")
    }

    fun observeViewModel() {
        viewModel = ViewModelProvider(this).get(MealsViewModel::class.java)
        viewModel.getMeals().observe(viewLifecycleOwner, Observer {
                result -> beefAdapter.updateMeals(result)
        })
    }
}