package com.example.ahsantrial.ui.home.viewholder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ahsantrial.data.entities.Item
import com.example.ahsantrial.databinding.ListItemBrandItemBinding

class BrandViewHolder(
    private val context: Context,
    private val binding: ListItemBrandItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(data: Item) {


        binding.txtBrand.text = data.name

        Glide
            .with(context)
            .load(data.logo)
            .into(binding.imgBrand)
    }

}