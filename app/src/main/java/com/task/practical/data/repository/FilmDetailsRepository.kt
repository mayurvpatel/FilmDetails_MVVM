package com.task.practical.data.repository

import com.task.practical.data.local.dao.FilmDetailsDao
import com.task.practical.data.remote.ApiService
import com.task.practical.model.response.FilmDetails
import javax.inject.Inject
import javax.inject.Singleton

interface FilmDetailsRepository {

    suspend fun getFilmDetailsList(): ArrayList<FilmDetails>

    suspend fun insertAllFilmDetailsList(filmDetailsList: ArrayList<FilmDetails>)

    suspend fun getAllFilmDetailsList(): List<FilmDetails>

    suspend fun clearTable()
}

/**
 * Implementation of [FilmDetailsRepository].
 */
@Singleton
class FilmDetailsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val itemsDao: FilmDetailsDao
) : FilmDetailsRepository {
    override suspend fun getFilmDetailsList(): ArrayList<FilmDetails> {
        return apiService.getFilmDetailsList()
    }

    override suspend fun insertAllFilmDetailsList(filmDetailsList: ArrayList<FilmDetails>) {
        itemsDao.insertAllFilmDetails(filmDetailsList)
    }

    override suspend fun getAllFilmDetailsList(): List<FilmDetails> =
        itemsDao.getAllFilmDetailsList()

    override suspend fun clearTable() {
        return itemsDao.clearTable()
    }

}
