package com.example.ahsantrial.ui.home.viewholder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.ahsantrial.data.entities.Item
import com.example.ahsantrial.databinding.ListItemCategorieItemBinding

class CategoriesViewHolder(
    private val context: Context,
    private val binding: ListItemCategorieItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(data: Item) {

        binding.txtCategory.text = data.name

    }

}