package com.example.ahsantrial.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ahsantrial.Constants
import com.example.ahsantrial.data.entities.HomeItem
import com.example.ahsantrial.databinding.ListItemBannerBinding
import com.example.ahsantrial.databinding.ListItemCategoriesBrandBinding
import com.example.ahsantrial.ui.home.viewholder.BannerViewHolder
import com.example.ahsantrial.ui.home.viewholder.CategoriesBrandViewHolder

class HomeAdapter(
    private val context: Context,
    private val list: MutableList<HomeItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val CATEGORIES_BRAND_VIEW_TYPE = 1
        const val BANNER_VIEW_TYPE = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            CATEGORIES_BRAND_VIEW_TYPE -> {
                val inflatedView = ListItemCategoriesBrandBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                CategoriesBrandViewHolder(context, inflatedView)
            }
            BANNER_VIEW_TYPE -> {
                val inflatedView = ListItemBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                BannerViewHolder(context, inflatedView)
            }
            else -> {
                throw RuntimeException("View Type not found")
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getViewType(list[position].type)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val homeObj = list[position]
        when (holder) {
            is CategoriesBrandViewHolder -> {
                holder.onBind(homeObj)
            }
            is BannerViewHolder -> {
                holder.onBind(homeObj)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


    private fun getViewType(type: String): Int {
        return when (type) {
            Constants.TYPE_CATEGORIES, Constants.TYPE_BRAND ->
                1
            Constants.TYPE_BANNER_SMALL, Constants.TYPE_BANNER_LARGE -> {
                2
            }
            else ->
                0
        }
    }


}