package com.example.hp

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.tasks.Task
import kotlinx.android.synthetic.main.fragment_restaurant.*


class RestaurantFragment : Fragment(R.layout.fragment_restaurant) {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var  newArrayList: ArrayList<DataRestaurant>
    lateinit var ImageResto : Array<Int>
    lateinit var nameResto : Array<String>

    val callback = OnMapReadyCallback { googleMap ->

        val clubParis = LatLng(61.21780422871915, -149.89018934313555)
        googleMap.addMarker(MarkerOptions().position(clubParis).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(clubParis))

        val bigBob = LatLng(34.6, -87.0)
        googleMap.addMarker(MarkerOptions().position(bigBob).title("Big Bob Gibson Bar-B-Q"))

        val McClard = LatLng(34.49644973055455, -93.07467261296195)
        googleMap.addMarker(MarkerOptions().position(McClard).title("McClard"))

        val charro = LatLng(32.348253262128765, -110.97640282121343)
        googleMap.addMarker(MarkerOptions().position(charro).title("El Charro Café"))

        val OldCamHouse = LatLng(37.74331099094029, -122.40488171476142)
        googleMap.addMarker(MarkerOptions().position(OldCamHouse).title("The Old Clam House"))

        val Buckhorn = LatLng(39.73244800083242, -105.005112214729)
        googleMap.addMarker(MarkerOptions().position(Buckhorn).title("Buckhorn Exchange Restaurant"))

        val Occidental = LatLng(43.67791470132513, -79.50618698048036)
        googleMap.addMarker(MarkerOptions().position(Occidental).title("New Orleans Seafood & Steakhouse"))

        val Lunch = LatLng(41.30915619967756, -72.93111284691666)
        googleMap.addMarker(MarkerOptions().position(Lunch).title("Louis' Lunch"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(Lunch))


        val tavern = LatLng(39.68328983356794, -75.75596934356538)
        googleMap.addMarker(MarkerOptions().position(tavern).title("Deer Park Tavern"))

        val JoeStone = LatLng(25.769333497424434, -80.13510768608977)
        googleMap.addMarker(MarkerOptions().position(JoeStone).title("Joe's Stone Crab Restaurant"))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //for recyclerview
        ImageResto = arrayOf(
            R.drawable.big_bob_gibson,
            R.drawable.club_paris,
            R.drawable.el_charro,
            R.drawable.mac_clards_bar_b_q,
            R.drawable.clam_house,
            R.drawable.buckhorn,
            R.drawable.louis_lunch,
            R.drawable.deer_park_tarvern,
            R.drawable.occidental,
            R.drawable.joe_stone_crab,
        )

        nameResto = arrayOf(
            "Big Bob Gibson Bar-B-Que",
            "Club Paris",
            "El Charro Cafe",
            "McClard's BBQ",
            "The Old Clam House",
            "Buckhorn Exchange",
            "Louis' Lunch",
            "Deer Park Tavern",
            "Occidental Grill & Seafood",
            "Joe's Stone Crab"
        )

        newRecyclerView = recyclerview_restaurants
        newRecyclerView.layoutManager = LinearLayoutManager(activity)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<DataRestaurant>()
        getData()

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)

    }

    private fun getData() {

        for (i in ImageResto.indices){

            val restaurant = DataRestaurant(ImageResto[i], nameResto[i])
            newArrayList.add(restaurant)
        }

        var adapter = Adapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : Adapter.onItemClickListener{

            //what should happen when we click on an item from the list
            override fun onItemClick(position: Int) {

                val action = RestaurantFragmentDirections.actionRestaurantFragmentToCategoryFragment()
                findNavController().navigate(action)

            }

            //must be here, but it is not used
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                return
            }

        })
    }





}
