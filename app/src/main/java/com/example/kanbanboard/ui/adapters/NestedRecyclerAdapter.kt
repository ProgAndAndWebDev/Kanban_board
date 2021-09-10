package com.example.kanbanboard.ui.adapters

import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import com.example.kanbanboard.BR
import com.example.kanbanboard.R
import com.example.kanbanboard.model.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers


class NestedRecyclerAdapter(
    items: List<com.example.kanbanboard.model.List>,
    listener: ListInteractionListener,
    val cardListener: CardInteractionListener,
    val createListener:ICreate
) :BaseRecycleAdapter<com.example.kanbanboard.model.List>(items,listener){
    override val layoutId: Int = R.layout.item_list

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when(holder){
            is ItemViewHolder -> {
                holder.binding.apply {
                    getItems()[position].also {list->
                        setVariable(BR.itemList,list)
                        Repository.getCardsByListId(list.listId)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe({
                                    setVariable(BR.cardAdapter,CardAdapter(it,cardListener,createListener,list.listId))
                                       },this@NestedRecyclerAdapter::onFail)
                    }
                }
            }
        }
    }
    private fun onFail(throwable: Throwable){
        Log.i("TAG",throwable.message.toString())
    }

    override lateinit var diffUtil: DiffUtil.Callback
    override fun setItems(newItems: List<com.example.kanbanboard.model.List>) {
        diffUtil=ListDiffUtil(getItems(),newItems)
        super.setItems(newItems)
    }

    class ListDiffUtil(
        items: List<com.example.kanbanboard.model.List>,
        newItems: List<com.example.kanbanboard.model.List>,
    ) : BaseDiffUtil<com.example.kanbanboard.model.List>(items,newItems) {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldList[oldItemPosition].listId == newList[newItemPosition].listId

    }
}
