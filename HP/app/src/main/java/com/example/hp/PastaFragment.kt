package com.example.hp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_burger.*
import kotlinx.android.synthetic.main.fragment_pasta.*

class PastaFragment : Fragment(R.layout.fragment_pasta) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clickListener()
    }

    private fun clickListener(){
        val action = PastaFragmentDirections.actionPastaFragmentToPastaIngredientsFragment()
        cvPastaBolognese.setOnClickListener {
            findNavController().navigate(action)
        }
        cvPastaSpinach.setOnClickListener {
            findNavController().navigate(action)
        }
        cvPastaSalmon.setOnClickListener {
            findNavController().navigate(action)
        }
        cvPastaShrimp.setOnClickListener {
            findNavController().navigate(action)
        }

    }
}