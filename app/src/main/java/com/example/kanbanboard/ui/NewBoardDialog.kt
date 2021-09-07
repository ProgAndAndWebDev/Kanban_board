package com.example.kanbanboard.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.kanbanboard.R
import com.example.kanbanboard.databinding.DialogAddNewBoardBinding
import com.example.kanbanboard.viewModels.NewBoardViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NewBoardDialog:BottomSheetDialogFragment() {

    lateinit var binding:DialogAddNewBoardBinding
    val viewModel:NewBoardViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        DataBindingUtil.inflate<DialogAddNewBoardBinding>(
            layoutInflater,
            R.layout.dialog_add_new_board,
            container,
            false)?.also{
                binding=it
        }?.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            this.lifecycleOwner=viewLifecycleOwner
            viewModel=this@NewBoardDialog.viewModel

            createButton.setOnClickListener{
                this@NewBoardDialog.viewModel.addBoard()
                Navigation.findNavController(requireActivity(),R.id.fragment_host).popBackStack()
            }


        }
    }


}