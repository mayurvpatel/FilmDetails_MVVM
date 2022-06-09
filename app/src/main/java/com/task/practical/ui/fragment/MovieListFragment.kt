package com.task.practical.ui.fragment

import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.task.practical.R
import com.task.practical.base.BaseFragment
import com.task.practical.data.result.Status
import com.task.practical.databinding.FragmentMovieListBinding
import com.task.practical.extension.showToast
import com.task.practical.extension.watch
import com.task.practical.model.interfaces.FilmDetailsClickListener
import com.task.practical.model.response.FilmDetails
import com.task.practical.states.MovieListState
import com.task.practical.ui.adapter.FilmDetailsItemAdapter
import com.task.practical.viewmodel.MovieListVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListFragment : BaseFragment<FragmentMovieListBinding, MovieListState,
        MovieListVM>(R.layout.fragment_movie_list), FilmDetailsClickListener {
    override val viewModel: MovieListVM by viewModels()
    private val filmDetailsItemAdapter: FilmDetailsItemAdapter by lazy {
        FilmDetailsItemAdapter()
    }

    override fun initializeViews() {
        super.initializeViews()
        binding.rvFilmDetailsList.adapter = filmDetailsItemAdapter
        filmDetailsItemAdapter.setOnFilmDetailsClickListener(this)
    }

    override fun observeViewState(state: MovieListState) {
        // Signup
        state.movieListLiveData.watch(this) {
            filmDetailsItemAdapter.submitList(it ?: arrayListOf())
        }
        state.movieListApiLiveEvent.watch(this) {
            when (it.status) {
                Status.ERROR -> {
                    viewModel.getAllFilmDetailsList()
                    showToast(it.throwable?.message.toString())
                }
                Status.SUCCESS -> {
                    viewModel.getAllFilmDetailsList()
                }
                Status.LOADING -> {}
            }
        }
    }

    override fun onFilmDetailsItemClick(mFilmDetails: FilmDetails) {
        showToast("${mFilmDetails.id} click.")
        val action =
            MovieListFragmentDirections.actionMovieListFragmentToMovieDetailsFragment(mFilmDetails.id)
        view?.findNavController()?.navigate(action)
    }
}
