package com.example.hp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_order.*

class OrderFragment : Fragment(R.layout.fragment_order) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_confirm.setOnClickListener{
            val action = OrderFragmentDirections.actionOrderFragmentToRestaurantFragment()
            findNavController().navigate(action)
        }
    }

}