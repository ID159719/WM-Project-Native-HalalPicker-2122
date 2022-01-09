package com.example.hp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_burger.*
import kotlinx.android.synthetic.main.fragment_pasta.*
import kotlinx.android.synthetic.main.fragment_pizza.*

class PizzaFragment : Fragment(R.layout.fragment_pizza) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clickListener()
    }

    private fun clickListener(){
        val action = PizzaFragmentDirections.actionPizzaFragmentToPizzaIngredientsFragment()
        cvPIzzaChicken.setOnClickListener {
            findNavController().navigate(action)
        }
        cvPizza4cheeses.setOnClickListener {
            findNavController().navigate(action)
        }
        cvPizzaMargharita.setOnClickListener {
            findNavController().navigate(action)
        }
        cvPizzaVegetarian.setOnClickListener {
            findNavController().navigate(action)
        }
    }
}