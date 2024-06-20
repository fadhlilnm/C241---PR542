package com.dicoding.inwarkop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.inwarkop.R
import com.dicoding.inwarkop.response.WarkopResponse

class WarkopAdapter(private val warkopList: List<WarkopResponse>) : RecyclerView.Adapter<WarkopAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_warkop, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val warkop = warkopList[position]
        holder.bind(warkop)
    }

    override fun getItemCount(): Int = warkopList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val addressTextView: TextView = itemView.findViewById(R.id.addressTextView)
        private val ratingTextView: TextView = itemView.findViewById(R.id.ratingTextView)
        private val ratingCountTextView: TextView = itemView.findViewById(R.id.ratingCountTextView)

        fun bind(warkop: WarkopResponse) {
            nameTextView.text = warkop.name
            addressTextView.text = warkop.address
            ratingTextView.text = warkop.rating
            ratingCountTextView.text = warkop.rating_count
        }
    }
}