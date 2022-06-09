package com.task.practical.states

import androidx.lifecycle.MutableLiveData
import com.task.practical.base.BaseState
import com.task.practical.data.result.Resource
import com.task.practical.model.response.FilmDetails
import javax.inject.Inject

/**
 * Movie list details state
 * @property movieListApiLiveEvent MutableLiveData<Resource<ArrayList<FilmDetails>>>
 * @property progressObservable MutableLiveData<Boolean>
 * @property movieListLiveData MutableLiveData<ArrayList<FilmDetails>>
 */
class MovieListState @Inject constructor() : BaseState {
    val movieListApiLiveEvent = MutableLiveData<Resource<ArrayList<FilmDetails>>>()
    val progressObservable = MutableLiveData<Boolean>(false)
    val movieListLiveData = MutableLiveData<ArrayList<FilmDetails>>()
}
