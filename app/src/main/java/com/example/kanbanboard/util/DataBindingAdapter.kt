package com.example.kanbanboard.util

import android.util.Log
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kanbanboard.R
import com.example.kanbanboard.ui.adapters.BaseRecycleAdapter

@BindingAdapter(value = ["app:checkIfFavorite"])
fun getFavourite(view: ImageView, value:Boolean){
    if(value)
        view.imageTintList= ContextCompat.getColorStateList(view.context,R.color.gold)
}


@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view:RecyclerView,items:List<T>?){
    (view.adapter as BaseRecycleAdapter<T>).run {
        if (items!=null){
            Log.i("TAG",items.toString())
            this.setItems(items)
        } else{
            setItems(emptyList())
            Log.i("TAG","null")
        }
    }
}