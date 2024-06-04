package com.dicoding.inwarkop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.inwarkop.databinding.ItemCardBinding

data class DetailItem(val imageUrl: String, val name: String, val address: String, val rating: String)

class DetailAdapter(private val items: List<DetailItem>) : RecyclerView.Adapter<DetailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(private val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DetailItem) {
            binding.nameText.text = item.name
            binding.addressText.text = item.address
            binding.ratingText.text = item.rating
            Glide.with(binding.imageView.context)
                .load(item.imageUrl)
                .into(binding.imageView)
        }
    }
}