package com.example.hp

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import kotlinx.android.synthetic.main.list_item_restaurant.view.*

class Adapter(private val listRestaurants : ArrayList<DataRestaurant>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    private lateinit var mListener : AdapterView.OnItemClickListener

    interface onItemClickListener : AdapterView.OnItemClickListener {

        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){

        mListener =  listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_restaurant,
        parent, false)

        return ViewHolder(itemView, mListener as onItemClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = listRestaurants[position]
        holder.imgRest.setImageResource(currentItem.img_resto)
        holder.nmRest.text = currentItem.name_resto

    }

    override fun getItemCount(): Int {

        return listRestaurants.size
    }

    class ViewHolder(itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){

        val imgRest : ShapeableImageView = itemView.img_restaurant
        val nmRest : TextView = itemView.name_restaurant

        init {
            itemView.setOnClickListener{
                listener.onItemClick(bindingAdapterPosition)
            }
        }

    }


}