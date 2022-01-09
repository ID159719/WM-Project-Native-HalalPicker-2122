package com.example.hp

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_burger.*
import kotlinx.android.synthetic.main.fragment_category.*
import kotlinx.android.synthetic.main.fragment_category.cvDurum
import kotlinx.android.synthetic.main.fragment_category.cvPizza

class BurgerFragment : Fragment(R.layout.fragment_burger) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clickListener()
    }

    private fun clickListener(){
        val action = BurgerFragmentDirections.actionBurgerFragmentToBurgerIngredientsFragment()
        cvVegetarian.setOnClickListener {
            findNavController().navigate(action)
        }
        cvCheeseBurger.setOnClickListener {
            findNavController().navigate(action)
        }
        cvRoyalBeef.setOnClickListener {
            findNavController().navigate(action)
        }
        cvWestCoast.setOnClickListener {
            findNavController().navigate(action)
        }

    }
}