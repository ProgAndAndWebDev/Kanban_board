package com.example.kanbanboard.ui.adapters

import android.view.View
import android.widget.ImageView
import com.example.kanbanboard.model.Board

interface BoardInteractionListener: BaseInteraction {
    fun onClickBoard(board: Board)
}