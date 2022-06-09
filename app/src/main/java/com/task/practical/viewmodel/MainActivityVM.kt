package com.task.practical.viewmodel

import com.task.practical.base.BaseState
import com.task.practical.base.BaseViewModel
import com.task.practical.states.MainActivityState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Main screen view model
 * @property state MainActivityState
 * @property sharedPrefs SharedPrefs
 * @constructor
 */
@HiltViewModel
class MainActivityVM @Inject constructor(
    private val state: MainActivityState
) : BaseViewModel() {
    override fun provideState(): BaseState = state

}
