package com.example.hp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_welcome.*

import androidx.navigation.NavOptions




class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    private val args: WelcomeFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //args ensures that the type stay the same during compiling => no compile error
        var username = args.username
        text_login.text = "You successfully\nlogged in\nas $username!"

        button_continue.setOnClickListener {
            val intent = Intent(context, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}