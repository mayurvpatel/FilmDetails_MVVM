package com.task.practical.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

/**
 * Binds Fragment scoped UI delegates.
 */
@Module
@InstallIn(FragmentComponent::class)
abstract class UiDelegateFragmentBindingModule
