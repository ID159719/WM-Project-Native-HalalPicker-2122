package com.example.hp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment : Fragment(R.layout.fragment_category) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clickListener()
    }

    private fun clickListener(){
        cvBurger.setOnClickListener {
            val action = CategoryFragmentDirections.actionCategoryFragmentToBurgerFragment()
            findNavController().navigate(action)
        }
        cvDurum.setOnClickListener {
            val action = CategoryFragmentDirections.actionCategoryFragmentToDurumFragment()
            findNavController().navigate(action)
        }
        cvPasta.setOnClickListener {
            val action = CategoryFragmentDirections.actionCategoryFragmentToPastaFragment()
            findNavController().navigate(action)
        }
        cvPizza.setOnClickListener {
            val action = CategoryFragmentDirections.actionCategoryFragmentToPizzaFragment()
            findNavController().navigate(action)
        }

    }
}