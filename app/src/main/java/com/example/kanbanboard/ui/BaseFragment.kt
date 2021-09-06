package com.example.kanbanboard.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB: ViewBinding>() : Fragment() {
     var _binding: ViewBinding?=null
     var binding: VB?
        get() = _binding as VB?
        set(value) = TODO()

    abstract val idLayout:Int
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    abstract fun setup()

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) :View? {
        return bindingInflater(inflater,idLayout,container,false)?.also { _binding=it }?.root
    }

    abstract val bindingInflater:(inflater: LayoutInflater, id: Int, container: ViewGroup?, b: Boolean) -> VB


    abstract val LOG_TAG: String
}
