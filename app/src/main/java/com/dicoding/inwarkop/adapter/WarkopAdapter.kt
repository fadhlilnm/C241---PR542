package com.dicoding.inwarkop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.inwarkop.R
import com.dicoding.inwarkop.response.WarkopResponse

class WarkopAdapter : ListAdapter<WarkopResponse, WarkopAdapter.ViewHolder>(WarkopDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_warkop, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val warkop = getItem(position)
        holder.bind(warkop)
    }

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

    class WarkopDiffCallback : DiffUtil.ItemCallback<WarkopResponse>() {
        override fun areItemsTheSame(oldItem: WarkopResponse, newItem: WarkopResponse): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: WarkopResponse, newItem: WarkopResponse): Boolean {
            return oldItem == newItem
        }
    }
}
