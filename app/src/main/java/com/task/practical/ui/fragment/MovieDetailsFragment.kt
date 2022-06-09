package com.task.practical.ui.fragment

import androidx.fragment.app.viewModels
import com.task.practical.R
import com.task.practical.base.BaseFragment
import com.task.practical.databinding.FragmentMovieDetailsBinding
import com.task.practical.states.MovieDetailsState
import com.task.practical.viewmodel.MovieDetailsVM
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MovieDetailsFragment :
    BaseFragment<FragmentMovieDetailsBinding, MovieDetailsState, MovieDetailsVM>(R.layout.fragment_movie_details) {
    override val viewModel: MovieDetailsVM by viewModels()

    override fun observeViewState(state: MovieDetailsState) {
        // observe View State
    }

    override fun initializeViews() {
        super.initializeViews()

    }


}