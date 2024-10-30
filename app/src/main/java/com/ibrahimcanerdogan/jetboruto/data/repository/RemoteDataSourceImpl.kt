package com.ibrahimcanerdogan.jetboruto.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ibrahimcanerdogan.jetboruto.data.local.BorutoDatabase
import com.ibrahimcanerdogan.jetboruto.data.paging.HeroRemoteMediator
import com.ibrahimcanerdogan.jetboruto.data.paging.SearchHeroesSource
import com.ibrahimcanerdogan.jetboruto.data.remote.BorutoAPI
import com.ibrahimcanerdogan.jetboruto.domain.model.Hero
import com.ibrahimcanerdogan.jetboruto.domain.repository.RemoteDataSource
import com.ibrahimcanerdogan.jetboruto.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow

@ExperimentalPagingApi
class RemoteDataSourceImpl(
    private val borutoApi: BorutoAPI,
    private val borutoDatabase: BorutoDatabase
) : RemoteDataSource {

    private val heroDao = borutoDatabase.heroDao()

    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        val pagingSourceFactory = { heroDao.getAllHeroes() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = HeroRemoteMediator(
                borutoApi = borutoApi,
                borutoDatabase = borutoDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchHeroes(query: String): Flow<PagingData<Hero>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                SearchHeroesSource(borutoApi = borutoApi, query = query)
            }
        ).flow
    }
}