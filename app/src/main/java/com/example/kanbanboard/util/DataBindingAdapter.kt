package com.example.kanbanboard.util

import android.util.Log
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.kanbanboard.ui.adapters.ISwipeElemnt
import com.example.kanbanboard.R
import com.example.kanbanboard.model.Card
import com.example.kanbanboard.ui.adapters.BaseRecycleAdapter
import com.example.kanbanboard.ui.adapters.BoardAdapter
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import www.sanju.zoomrecyclerlayout.ZoomRecyclerLayout

@BindingAdapter(value = ["app:checkIfImportant"])
fun ifImportant(view: ImageView, value:Boolean){
   if(value)
       view.setBackgroundColor(ContextCompat.getColor(view.context,R.color.red))
    else
       view.setBackgroundColor(ContextCompat.getColor(view.context,R.color.blue))
}


@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view:RecyclerView,items:List<T>?){
    (view.adapter as BaseRecycleAdapter<T>).run {
        if (items!=null){
            Log.i("TAG",items.toString())
            this.setItems(items)
        } else{
            setItems(emptyList())
            Log.i("TAG","null")
        }
    }
}
@BindingAdapter(value=["app:chartData"])
fun setData(view:PieChart,value:List<Card>?){
    value?.let {
        val kk=value.groupBy { it.listId }.map{
            PieEntry(it.value.size.toFloat(),it.key.toFloat())
        }
        view.data= PieData(PieDataSet(kk,""))
        view.notifyDataSetChanged()
    }
}

@BindingAdapter(value = ["app:swipe"])
fun swipe(view: RecyclerView,delete: ISwipeElemnt){
    ItemTouchHelper(object :ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT){
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder,
        ): Boolean {
            return false
        }
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            delete.swipeBoard((view.adapter as BoardAdapter).getBoardAt(viewHolder.adapterPosition))
        }
    }).attachToRecyclerView(view)
}

@BindingAdapter(value=["app:ifZoom"])
fun setZoom(view:RecyclerView,value: Int){
    view.layoutManager=ZoomRecyclerLayout(view.context)
        .apply{
            orientation = value
            reverseLayout = true
            stackFromEnd = true
        }
}
