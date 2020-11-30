package com.technical.cats.ui.main

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.technical.domain.Cat


@BindingAdapter("items")
fun RecyclerView.setItems(names: List<Cat>?) {
    (adapter as? CatNameAdapter)?.let {
        it.cats = names ?: emptyList()
    }
}