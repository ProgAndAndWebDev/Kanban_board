package com.example.kanbanboard.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.kanbanboard.R
import com.example.kanbanboard.model.Card

class CardAdapter(items:List<Card>,listener:CardInteractionListener ):BaseRecycleAdapter<Card>(items,listener) {
    override val layoutId: Int= R.layout.item_card
    override lateinit var diffUtil: DiffUtil.Callback
    override fun setItems(newItems: List<Card>) {
        CardFDiffUtil(getItems(),newItems)
        super.setItems(newItems)
    }

}

class CardFDiffUtil(items: List<Card>, newItems: List<Card>):BaseDiffUtil<Card>(items,newItems) {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int)=
        oldList[oldItemPosition].cardId== newList[newItemPosition].cardId
}