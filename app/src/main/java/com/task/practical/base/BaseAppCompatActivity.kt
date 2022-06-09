package com.task.practical.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.task.practical.BR

/**
 * Base activity for each and every activity
 *
 * @param Binding : ViewDataBinding
 * @param STATE : BaseState
 * @param ViewModel : BaseViewModel
 * @property layoutId Int
 * @property state STATE
 * @property binding Binding
 * @property viewModel ViewModel
 * @constructor
 */
@SuppressWarnings("unchecked")
abstract class BaseAppCompatActivity<Binding : ViewDataBinding,
        STATE : BaseState, ViewModel : BaseViewModel>(@LayoutRes val layoutId: Int) :
    AppCompatActivity() {

    protected val state: STATE by lazy {
        viewModel.provideState() as STATE
    }

    protected lateinit var binding: Binding
    protected abstract val viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindViewModel()
        observeViewState(state)
    }

    /**
     * Initialize observers for [ViewModel].
     *
     * @param viewModel
     */
    abstract fun observeViewState(state: STATE)

    /**
     * This function will be executed when onCreate() is called.
     */
    open fun initializeViews() {}

    private fun bindViewModel() {
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.apply {
            lifecycleOwner = this@BaseAppCompatActivity
            setVariable(BR.viewModel, viewModel)
            setVariable(BR.state, state)
        }
        binding.executePendingBindings()
        initializeViews()
    }
}
