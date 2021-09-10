package com.example.kanbanboard.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.example.kanbanboard.BR
import com.example.kanbanboard.R
import com.example.kanbanboard.model.Card

class CardAdapter(items:List<Card>,listener:CardInteractionListener,val createListener:ICreate,val listId:Int):BaseRecycleAdapter<Card>(items,listener) {
    override val layoutId: Int= R.layout.item_card
    override lateinit var diffUtil: DiffUtil.Callback

    override fun setItems(newItems: List<Card>) {
        CardFDiffUtil(getItems(),newItems)
        super.setItems(newItems)
    }

    class AddCardViewHolder(val binding:ViewDataBinding):BaseViewHolder(binding)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
    return    when(viewType){
            CARD -> ItemViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),layoutId,parent,false))
            ADD_CARD -> AddCardViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.item_add_card,parent,false))
        else -> throw Exception("UNKNOWN VIEW TYPE")
    }
    }
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {

        super.onBindViewHolder(holder, position)
        when(holder){
            is AddCardViewHolder->{
                holder.binding.apply {
                    setVariable(BR.createListener,createListener)
                    setVariable(BR.listId,listId)
                }
            }
        }
    }

    override fun getItemCount()=getItems().size+1
    override fun getItemViewType(position: Int) =
        when(position){
            0 -> ADD_CARD
            else -> CARD
        }

    companion object{
        const val ADD_CARD=0
        const val CARD=1
    }
}

class CardFDiffUtil(items: List<Card>, newItems: List<Card>):BaseDiffUtil<Card>(items,newItems) {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int)=
        oldList[oldItemPosition].cardId== newList[newItemPosition].cardId
}