package com.example.hp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment(R.layout.fragment_register) {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_register.setOnClickListener{
            val username = edUsername.text.toString()

            val action = RegisterFragmentDirections.actionRegisterFragmentToWelcomeFragment(username)
            findNavController().navigate(action)
        }
    }


}