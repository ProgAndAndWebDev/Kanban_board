package com.example.kanbanboard.ui.adapters

import com.example.kanbanboard.model.Board

class BoardDiffUtil(oldList: List<Board>, newList:List<Board>)
    :BaseDiffUtil<Board>(oldList,newList) {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int)=
        oldList[oldItemPosition].boardId== newList[newItemPosition].boardId

}