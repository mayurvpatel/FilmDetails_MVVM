package com.task.practical.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.task.practical.model.response.FilmDetails

/**
 * The DAO for [FilmDetailsDao].
 */
@Dao
interface FilmDetailsDao {
    /**
     * Insert list of [FilmDetails] and replace on conflict.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllFilmDetails(filmDetailsList: List<FilmDetails>)

    /**
     * Get all film details data.
     * @return all film details as list
     */
    @Query("SELECT * FROM FilmDetails")
    fun getAllFilmDetailsList(): List<FilmDetails>

    /**
     * Delete [FilmDetails] one item from table
     * @param mFilmDetails
     */
    @Delete
    fun delete(mFilmDetails: FilmDetails)

    /**
     * delete file details from the table
     */
    @Query("DELETE FROM FilmDetails")
    fun clearTable()
}
