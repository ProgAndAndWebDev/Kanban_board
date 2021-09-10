package com.example.kanbanboard.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.kanbanboard.R
import com.example.kanbanboard.model.Board

class BoardAdapter(itemsL:List<Board>,listener: BoardInteractionListener)
    :BaseRecycleAdapter<Board>(itemsL,listener) {
    override lateinit var  diffUtil: DiffUtil.Callback

    override val layoutId: Int= R.layout.item_board
    override fun setItems(newItems: List<Board>) {
        diffUtil=BoardDiffUtil(getItems(),newItems)
        super.setItems(newItems)
    }
    fun getBoardAt(position:Int)=
        getItems()[position]
//    fun removeItem(postion:Int){
//        Repository.deleteBoard(getItems()[postion])
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe()
//        notifyDataSetChanged()
//    }

}