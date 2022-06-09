package com.task.practical.di

import android.content.Context
import com.task.practical.data.local.AppDatabase
import com.task.practical.data.local.dao.FilmDetailsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Defines all the classes that need to be provided in the scope of the app.
 * If they are singleton mark them as '@Singleton'.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        AppDatabase.buildDatabase(context)

    @Singleton
    @Provides
    fun provideItemsDao(appDatabase: AppDatabase): FilmDetailsDao = appDatabase.filmDetailsDao()
}
