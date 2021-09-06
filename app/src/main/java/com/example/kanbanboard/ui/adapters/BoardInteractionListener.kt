package com.example.kanbanboard.ui.adapters

import com.example.kanbanboard.model.Board

interface BoardInteractionListener: BaseInteraction {
    fun onClickBoard(board: Board)
}