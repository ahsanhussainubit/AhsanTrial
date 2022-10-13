package com.example.ahsantrial.ui.home.viewholder

import android.content.Context
import android.graphics.Color
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ahsantrial.data.entities.HomeItem
import com.example.ahsantrial.data.entities.Item
import com.example.ahsantrial.databinding.ListItemBannerBinding
import com.example.ahsantrial.ui.utils.Utils
import com.google.gson.Gson


class BannerViewHolder(
    private val context: Context,
    private val binding: ListItemBannerBinding
) : RecyclerView.ViewHolder(binding.root) {


    fun onBind(data: HomeItem) {
        binding.ccMain.setBackgroundColor(
            Color.parseColor(data.backgroundColor)
        )


        val item = Utils.jsonToAny(data.items,Item::class.java) as Item


        Glide
            .with(context)
            .load(item.image)
            .into(binding.imgBanner)

    }


}