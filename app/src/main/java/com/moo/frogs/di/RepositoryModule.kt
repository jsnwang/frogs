package com.moo.frogs.di

import com.moo.frogs.model.FrogsRepository
import com.moo.frogs.model.FrogsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class) // Or whichever component you're providing to
object RepositoryModule {

    @Provides
    fun provideFrogsRepository(service: FrogsService): FrogsRepository {
        return FrogsRepository(service)
    }
}