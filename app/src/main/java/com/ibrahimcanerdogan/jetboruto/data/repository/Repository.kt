package com.ibrahimcanerdogan.jetboruto.data.repository

import androidx.paging.PagingData
import com.ibrahimcanerdogan.jetboruto.domain.model.Hero
import com.ibrahimcanerdogan.jetboruto.domain.repository.DataStoreOperations
import com.ibrahimcanerdogan.jetboruto.domain.repository.LocalDataSource
import com.ibrahimcanerdogan.jetboruto.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val local: LocalDataSource,
    private val remote: RemoteDataSource,
    private val dataStore: DataStoreOperations
) {

    fun getAllHeroes(): Flow<PagingData<Hero>> {
        return remote.getAllHeroes()
    }

    fun searchHeroes(query: String): Flow<PagingData<Hero>> {
        return remote.searchHeroes(query = query)
    }

    suspend fun getSelectedHero(heroId: Int): Hero {
        return local.getSelectedHero(heroId = heroId)
    }

    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed = completed)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }

}