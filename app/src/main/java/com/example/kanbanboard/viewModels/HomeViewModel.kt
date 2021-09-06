package com.example.kanbanboard.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kanbanboard.model.Board
import com.example.kanbanboard.model.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel: ViewModel() {

    val boards=MutableLiveData<List<Board>>()
    val mm=MutableLiveData<String>()

    init {
        getBoards()
    }

    private fun getBoards() {
        Repository.getAllBoards()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    boards.postValue(it)
                },{
                    Log.i("TAG",it.message.toString())
                })
    }
}