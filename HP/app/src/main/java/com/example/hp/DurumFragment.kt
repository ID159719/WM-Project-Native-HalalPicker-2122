package com.example.hp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_burger.*
import kotlinx.android.synthetic.main.fragment_category.*
import kotlinx.android.synthetic.main.fragment_durum.*

class DurumFragment : Fragment(R.layout.fragment_durum) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clickListener()
    }

    private fun clickListener(){
        val action = DurumFragmentDirections.actionDurumFragmentToDurumIngredientsFragment()
        cvDurumChicken.setOnClickListener {
            findNavController().navigate(action)
        }
        cvDurumKebab.setOnClickListener {
            findNavController().navigate(action)
        }
        cvDurumKofte.setOnClickListener {
            findNavController().navigate(action)
        }
        cvDurumMerguez.setOnClickListener {
            findNavController().navigate(action)
        }

    }
}