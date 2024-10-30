package com.ibrahimcanerdogan.jetboruto.di

import android.content.Context
import com.ibrahimcanerdogan.jetboruto.data.repository.DataStoreOperationsImpl
import com.ibrahimcanerdogan.jetboruto.data.repository.Repository
import com.ibrahimcanerdogan.jetboruto.domain.repository.DataStoreOperations
import com.ibrahimcanerdogan.jetboruto.domain.usecase.UseCases
import com.ibrahimcanerdogan.jetboruto.domain.usecase.GetAllHeroesUseCase
import com.ibrahimcanerdogan.jetboruto.domain.usecase.GetSelectedHeroUseCase
import com.ibrahimcanerdogan.jetboruto.domain.usecase.ReadOnBoardingUseCase
import com.ibrahimcanerdogan.jetboruto.domain.usecase.SaveOnBoardingUseCase
import com.ibrahimcanerdogan.jetboruto.domain.usecase.SearchHeroesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(
        @ApplicationContext context: Context
    ): DataStoreOperations {
        return DataStoreOperationsImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository),
            getAllHeroesUseCase = GetAllHeroesUseCase(repository),
            searchHeroesUseCase = SearchHeroesUseCase(repository),
            getSelectedHeroUseCase = GetSelectedHeroUseCase(repository)
        )
    }

}