package com.task.practical.data.remote

import com.task.practical.model.response.FilmDetails
import retrofit2.http.GET

/**
 * Provides remote APIs
 */
interface ApiService {
    @GET("/films")
    suspend fun getFilmDetailsList(): ArrayList<FilmDetails>
}
