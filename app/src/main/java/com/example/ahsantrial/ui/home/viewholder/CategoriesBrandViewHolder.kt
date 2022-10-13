package com.example.ahsantrial.ui.home.viewholder

import android.content.Context
import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ahsantrial.Constants
import com.example.ahsantrial.data.entities.HomeItem
import com.example.ahsantrial.data.entities.Item
import com.example.ahsantrial.databinding.ListItemCategoriesBrandBinding
import com.example.ahsantrial.ui.home.adapter.CategoriesAdapter
import com.example.ahsantrial.ui.utils.Utils


class CategoriesBrandViewHolder(
    private val context: Context,
    private val binding: ListItemCategoriesBrandBinding
) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var categoriesAdapter: CategoriesAdapter

    fun onBind(data: HomeItem) {

        binding.ccMain.setBackgroundColor(
            Color.parseColor(data.backgroundColor)
        )

        binding.txtHeading.text = data.title

        binding.txtSeeAll.visibility = if (data.isSeeAllShown) View.VISIBLE else View.GONE


        val list = Utils.jsonToList(data.items)

        initRecyclerView(isCategory = isCategory(data.type), list = list)


    }

    private fun initRecyclerView(isCategory: Boolean, list: MutableList<Item>) {
        categoriesAdapter = CategoriesAdapter(context, isCategory, list)

        binding.rcvCategories.apply {
            adapter = categoriesAdapter
            layoutManager =
                if (isCategory)
                    GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)
                else
                    LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        }
    }

    private fun isCategory(type: String): Boolean {
        return type == Constants.TYPE_CATEGORIES
    }

}