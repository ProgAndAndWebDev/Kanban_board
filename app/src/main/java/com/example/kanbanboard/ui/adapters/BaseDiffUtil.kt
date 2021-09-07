package com.example.kanbanboard.ui.adapters

import androidx.recyclerview.widget.DiffUtil

 abstract class BaseDiffUtil<T>(val oldList: List<T>, val newList:List<T>) :DiffUtil.Callback(){
    override fun getOldListSize()= oldList.size

    override fun getNewListSize() =newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }
}