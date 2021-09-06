package com.example.kanbanboard.ui.adapters

import com.example.kanbanboard.R
import com.example.kanbanboard.model.Board

class BoardAdapter(items:List<Board>,listener: BoardInteractionListener)
    :BaseRecycleAdapter<Board>(items,listener) {

    override val layoutId: Int= R.layout.item_board

    }