package com.example.kanbanboard.ui.adapters

import com.example.kanbanboard.R
import com.example.kanbanboard.model.Card

class CardAdapter(items:List<Card>,listener:CardInteractionListener ):BaseRecycleAdapter<Card>(items,listener) {
    override val layoutId: Int= R.layout.item_card
}