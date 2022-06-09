package com.task.practical.data.local.dao

import com.task.practical.data.local.AppDatabase
import javax.inject.Inject
import javax.inject.Singleton

/**
 * [AppDatabase] API surface.
 *
 * Restricts unwanted operations directly on [AppDatabase].
 */
interface AppDatabaseDao {
    /**
     * Clear the whole database.
     *
     * NOTE : This operation can not be undone.
     */
    suspend fun clear()
}

/**
 * Implementation of [AppDatabaseDao].
 */
@Singleton
class AppDatabaseImpl @Inject constructor(
    private val appDatabase: AppDatabase
) : AppDatabaseDao {
    override suspend fun clear() {
        appDatabase.clearAllTables()
    }
}
