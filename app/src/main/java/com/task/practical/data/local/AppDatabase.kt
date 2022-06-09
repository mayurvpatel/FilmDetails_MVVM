package com.task.practical.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.task.practical.data.local.dao.FilmDetailsDao
import com.task.practical.model.response.FilmDetails

/**
 * The [Room] database for this app.
 */
@Database(
    entities = [FilmDetails::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun filmDetailsDao(): FilmDetailsDao

    companion object {
        private const val databaseName = "Film_db"

        /**
         * Build and return [RoomDatabase] instance of the app.
         *
         * @param [context] application context
         *
         * @return [AppDatabase] instance
         * */
        fun buildDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, databaseName)
                .build()
    }
}
