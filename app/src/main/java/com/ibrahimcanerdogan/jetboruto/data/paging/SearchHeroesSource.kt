package com.ibrahimcanerdogan.jetboruto.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ibrahimcanerdogan.jetboruto.data.remote.BorutoAPI
import com.ibrahimcanerdogan.jetboruto.domain.model.Hero
import java.lang.Exception

class SearchHeroesSource(
    private val borutoApi: BorutoAPI,
    private val query: String
) : PagingSource<Int, Hero>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Hero> {
        return try {
            val apiResponse = borutoApi.searchHeroes(name = query)
            val heroes = apiResponse.heroes
            if (heroes.isNotEmpty()) {
                LoadResult.Page(
                    data = heroes,
                    prevKey = apiResponse.prevPage,
                    nextKey = apiResponse.nextPage
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Hero>): Int? {
        return state.anchorPosition
    }
}