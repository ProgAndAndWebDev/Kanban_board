package com.example.kanbanboard.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kanbanboard.model.Card
import com.example.kanbanboard.model.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*

class AddCardViewModel:ViewModel() {
    val title= MutableLiveData<String>()
    val description= MutableLiveData<String>()

    fun addCard(listId:Int){
        if(title.value !=null &&description.value !=null
        ){
            Repository.insertCard(
                Card(listId=listId,
                    title=title.value!!,
                    description =description.value!!,
                    createdDate = Date(),
                    lastUpdatedDate = Date()
                )
            ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
        }
    }
}