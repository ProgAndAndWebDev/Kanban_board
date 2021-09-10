package com.example.kanbanboard.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.kanbanboard.R
import com.example.kanbanboard.databinding.DialogAddListBinding
import com.example.kanbanboard.databinding.DialogAddNewBoardBinding
import com.example.kanbanboard.viewModels.NewListViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NewListDialog:BottomSheetDialogFragment() {

    val args:NewListDialogArgs by navArgs()

    lateinit var binding:DialogAddListBinding
    val viewModel: NewListViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        DataBindingUtil.inflate<DialogAddListBinding>(
            layoutInflater,
            R.layout.dialog_add_list,
            container,
            false)?.also{
                binding=it
        }?.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            this.lifecycleOwner=viewLifecycleOwner
            viewModel=this@NewListDialog.viewModel

            addButton.setOnClickListener{
                this@NewListDialog.viewModel.addList(args.boardId)
                Navigation.findNavController(requireActivity(),R.id.fragment_host).popBackStack()
            }


        }
    }


}