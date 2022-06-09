package com.task.practical.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/**
 * Binds Activity scoped UI delegates.
 */
@Module
@InstallIn(ActivityComponent::class)
@Suppress("EmptyClassBlock")
abstract class UiDelegateActivityBindingModule