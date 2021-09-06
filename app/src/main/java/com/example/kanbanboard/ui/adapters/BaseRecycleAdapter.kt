package com.example.kanbanboard.ui.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.kanbanboard.BR

abstract class BaseRecycleAdapter<T>(private var items:List<T>, val listener: BaseInteraction):
        RecyclerView.Adapter<BaseRecycleAdapter.BaseViewHolder>(){

    abstract val layoutId :Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
        ItemViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),layoutId,parent,false))

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when(holder){
            is ItemViewHolder -> {
                try {
                    holder.binding.apply {
                        setVariable(BR.item,items[position])
                        setVariable(BR.listener,listener)
                    }
                }
                catch (e:Exception){

                }
            }
        }
    }

    fun setItems(newItems:List<T>){
        items=newItems
        notifyDataSetChanged()
    }

    fun getItems() = items

    override fun getItemCount(): Int =items.size

    class ItemViewHolder(val binding: ViewDataBinding): BaseViewHolder(binding)

    abstract class BaseViewHolder( binding: ViewDataBinding):RecyclerView.ViewHolder(binding.root)

}

interface BaseInteraction