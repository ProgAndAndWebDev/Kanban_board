package com.example.kanbanboard.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.kanbanboard.R
import com.example.kanbanboard.databinding.FragmentCardDetailsBinding
import com.example.kanbanboard.viewModels.AddCardViewModel

class CardDetailsFragment
    :BaseFragment<FragmentCardDetailsBinding>(){
    override val idLayout: Int= R.layout.fragment_card_details
    val args:CardDetailsFragmentArgs by navArgs()
    val viewModel:AddCardViewModel by viewModels()

    override fun setup() {
        binding?.apply {
            this.viewModel = this@CardDetailsFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
            listId = args.listId
        }
    }
    override val bindingInflater: (inflater: LayoutInflater, id: Int, container: ViewGroup?, b: Boolean) -> FragmentCardDetailsBinding =
        DataBindingUtil::inflate
        override val LOG_TAG: String="Card_Detail"
}