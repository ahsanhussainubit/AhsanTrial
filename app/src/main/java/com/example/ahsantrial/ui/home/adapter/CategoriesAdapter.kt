package com.example.ahsantrial.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ahsantrial.data.entities.Item
import com.example.ahsantrial.databinding.ListItemBrandItemBinding
import com.example.ahsantrial.databinding.ListItemCategorieItemBinding
import com.example.ahsantrial.ui.home.viewholder.BrandViewHolder
import com.example.ahsantrial.ui.home.viewholder.CategoriesViewHolder

class CategoriesAdapter(
    val context: Context,
    val isCategory: Boolean,
    private val list: MutableList<Item>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val CATEGORIES_VIEW_TYPE = 1
        const val BRAND_VIEW_TYPE = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            CATEGORIES_VIEW_TYPE -> {
                val inflatedView = ListItemCategorieItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                CategoriesViewHolder(context, inflatedView)
            }
            BRAND_VIEW_TYPE -> {
                val inflatedView = ListItemBrandItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                BrandViewHolder(context, inflatedView)
            }
            else -> {
                throw RuntimeException()
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (isCategory)
            CATEGORIES_VIEW_TYPE
        else
            BRAND_VIEW_TYPE
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val homeObj = list[position]
        when (holder) {
            is CategoriesViewHolder -> {
                holder.onBind(homeObj)
            }
            is BrandViewHolder -> {
                holder.onBind(homeObj)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}