package com.technical.cats.ui.main


import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.technical.cats.R

import com.technical.cats.databinding.NameListItemBinding

import com.technical.cats.ui.common.basicDiffUtil
import com.technical.cats.ui.common.bindingInflate
import com.technical.domain.Cat

class CatNameAdapter:
    RecyclerView.Adapter<CatNameAdapter.ViewHolderCat>() {

    val TAG=CatNameAdapter::class.java.simpleName
    var cats: List<Cat> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old, new -> old.id == new.id }
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCat =
        ViewHolderCat(parent.bindingInflate(R.layout.name_list_item, false))

    override fun getItemCount(): Int = cats.size

    override fun onBindViewHolder(holder: ViewHolderCat, position: Int) {
        val listNameCat = cats.sortedBy { it.name }

        val cat = listNameCat[position]


        holder.dataBinding.cat = cat

    }

    class ViewHolderCat(val dataBinding: NameListItemBinding) : RecyclerView.ViewHolder(dataBinding.root)
    }



