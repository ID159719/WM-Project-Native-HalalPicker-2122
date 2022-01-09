package com.example.hp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback

import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.toolbar

import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class HomeActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //we have to do it like that, otherwise it crashes
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        //start destination of nav graph is fragment_home
        //when the activity becomes activity_home
        //we want the start destination to be fragment_restaurant
        //the code below changes the start destination to fragment_restaurant

        val graphInflater = navHostFragment.navController.navInflater
        val navGraph = graphInflater.inflate(R.navigation.nav_graph)
        navController = navHostFragment.navController
        navGraph.startDestination = R.id.restaurantFragment
        navController.graph = navGraph

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.restaurantFragment, R.id.orderFragment, R.id.profileFragment)
        )

        //connect bottom_nav to nav_graph
        setSupportActionBar(toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottom_nav.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }




}