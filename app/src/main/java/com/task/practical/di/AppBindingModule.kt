package com.task.practical.di

import com.task.practical.data.local.dao.AppDatabaseDao
import com.task.practical.data.local.dao.AppDatabaseImpl
import com.task.practical.data.repository.FilmDetailsRepository
import com.task.practical.data.repository.FilmDetailsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Defines all the classes that need to be provided in the scope of the app.
 * If they are singleton mark them as '@Singleton'.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class AppBindingModule {
    @Singleton
    @Binds
    abstract fun bindFilmDetailsRepository(itemsRepository: FilmDetailsRepositoryImpl): FilmDetailsRepository

    @Singleton
    @Binds
    abstract fun bindAppDatabaseDao(appDatabaseImpl: AppDatabaseImpl): AppDatabaseDao
}
