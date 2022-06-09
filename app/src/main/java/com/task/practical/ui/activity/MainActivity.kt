package com.task.practical.ui.activity

import androidx.activity.viewModels
import com.task.practical.R
import com.task.practical.base.BaseAppCompatActivity
import com.task.practical.databinding.ActivityMainBinding
import com.task.practical.states.MainActivityState
import com.task.practical.viewmodel.MainActivityVM
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity :
    BaseAppCompatActivity<ActivityMainBinding, MainActivityState, MainActivityVM>(R.layout.activity_main) {

    override val viewModel: MainActivityVM by viewModels()

    override fun observeViewState(state: MainActivityState) {
        // observer
    }

    override fun initializeViews() {
        super.initializeViews()
    }
}