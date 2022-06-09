package com.task.practical.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.task.practical.BR

/**
 * Base fragment for all fragments.
 *
 * @param Binding : ViewDataBinding
 * @param STATE : BaseState
 * @param ViewModel : BaseViewModel
 * @property layoutId Int
 * @property binding Binding
 * @property viewModel ViewModel
 * @property state STATE
 * @constructor
 */
abstract class BaseFragment<Binding : ViewDataBinding,
        STATE : BaseState,
        ViewModel : BaseViewModel>(@LayoutRes val layoutId: Int) : Fragment() {

    protected lateinit var binding: Binding
    protected abstract val viewModel: ViewModel
    protected val state: STATE by lazy {
        viewModel.provideState() as STATE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeViewState(state)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return initializeDataBinding(inflater, container).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
    }

    open fun initializeViews() {}

    private fun initializeDataBinding(inflater: LayoutInflater, container: ViewGroup?): Binding =
        DataBindingUtil.inflate<Binding>(inflater, layoutId, container, false).apply {
            binding = this
            lifecycleOwner = this@BaseFragment
            setVariable(BR.viewModel, viewModel)
            setVariable(BR.state, state)
            executePendingBindings()
        }

    abstract fun observeViewState(state: STATE)

}
