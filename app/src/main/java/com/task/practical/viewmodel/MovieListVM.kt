package com.task.practical.viewmodel

import androidx.lifecycle.viewModelScope
import com.task.practical.base.BaseState
import com.task.practical.base.BaseViewModel
import com.task.practical.data.repository.FilmDetailsRepository
import com.task.practical.data.result.Resource
import com.task.practical.data.result.Status
import com.task.practical.model.response.FilmDetails
import com.task.practical.states.MovieListState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 * film api call and store details in local db
 * @property state MovieListState
 * @property filmDetailsRepository FilmDetailsRepository
 * @constructor
 */
@HiltViewModel
class MovieListVM @Inject constructor(
    private val state: MovieListState,
    private val filmDetailsRepository: FilmDetailsRepository
) : BaseViewModel() {
    override fun provideState(): BaseState = state

    init {
        getFilmDetailsList()
    }

    /**
     * get film details from backend and store in the local database
     */
    private fun getFilmDetailsList() {
        state.progressObservable.value = true
        state.movieListApiLiveEvent.value = Resource(Status.LOADING)
        viewModelScope.launch {
            runCatching {
                filmDetailsRepository.getFilmDetailsList()
            }.onSuccess {
                Timber.d("Data --> $it")
                state.movieListApiLiveEvent.value =
                    if (it.isNullOrEmpty().not()) {
                        withContext(Dispatchers.IO) {
                            filmDetailsRepository.insertAllFilmDetailsList(it)
                        }
                        state.progressObservable.value = false
                        Resource(Status.SUCCESS, it)
                    } else {
                        state.progressObservable.value = false
                        Resource(Status.ERROR, Throwable("No data found"))
                    }
            }.onFailure {
                state.progressObservable.value = false
                state.movieListApiLiveEvent.value = Resource(Status.ERROR, it)
            }
        }
    }

    /**
     * Fetch all film details from the list
     */
    fun getAllFilmDetailsList() {
        viewModelScope.launch(Dispatchers.IO) {
            state.movieListLiveData.postValue(filmDetailsRepository.getAllFilmDetailsList() as ArrayList<FilmDetails>?)
        }
    }
}
