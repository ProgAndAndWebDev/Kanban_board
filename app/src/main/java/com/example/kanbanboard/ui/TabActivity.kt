package com.example.kanbanboard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.kanbanboard.R
import com.example.kanbanboard.databinding.ActivityTabBinding

class TabActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        com.example.kanbanboard.model.Database.getInstance(applicationContext)
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityTabBinding>(this,
            R.layout.activity_tab).also { binding ->
            binding.lifecycleOwner=this
        }
    }
}