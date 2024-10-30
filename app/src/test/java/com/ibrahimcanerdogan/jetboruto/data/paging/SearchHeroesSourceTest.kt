package com.ibrahimcanerdogan.jetboruto.data.paging

import androidx.paging.PagingSource.LoadParams
import androidx.paging.PagingSource.LoadResult
import com.ibrahimcanerdogan.jetboruto.data.remote.BorutoAPI
import com.ibrahimcanerdogan.jetboruto.data.remote.FakeBorutoAPI
import com.ibrahimcanerdogan.jetboruto.domain.model.Hero
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@ExperimentalCoroutinesApi
class SearchHeroesSourceTest {

    private lateinit var borutoApi: BorutoAPI
    private lateinit var heroes: List<Hero>

    @Before
    fun setup() {
        borutoApi = FakeBorutoAPI()
        heroes = listOf(
            Hero(
                heroId = 1,
                heroName = "Sasuke",
                heroImage = "",
                heroAbout = "",
                heroRating = 5.0,
                heroPower = 0,
                heroMonth = "",
                heroDay = "",
                heroFamily = listOf(),
                heroAbilities = listOf(),
                heroNatureTypes = listOf()
            ),
            Hero(
                heroId = 2,
                heroName = "Naruto",
                heroImage = "",
                heroAbout = "",
                heroRating = 5.0,
                heroPower = 0,
                heroMonth = "",
                heroDay = "",
                heroFamily = listOf(),
                heroAbilities = listOf(),
                heroNatureTypes = listOf()
            ),
            Hero(
                heroId = 3,
                heroName = "Sakura",
                heroImage = "",
                heroAbout = "",
                heroRating = 5.0,
                heroPower = 0,
                heroMonth = "",
                heroDay = "",
                heroFamily = listOf(),
                heroAbilities = listOf(),
                heroNatureTypes = listOf()
            )
        )
    }

    @Test
    fun `Search api with existing hero name, expect single hero result, assert LoadResult_Page`() =
        runTest {
            val heroSource = SearchHeroesSource(borutoApi = borutoApi, query = "Sasuke")
            assertEquals<LoadResult<Int, Hero>>(
                expected = LoadResult.Page(
                    data = listOf(heroes.first()),
                    prevKey = null,
                    nextKey = null
                ),
                actual = heroSource.load(
                    LoadParams.Refresh(
                        key = null,
                        loadSize = 3,
                        placeholdersEnabled = false
                    )
                )
            )
        }

    @Test
    fun `Search api with existing hero name, expect multiple hero result, assert LoadResult_Page`() =
        runTest {
            val heroSource = SearchHeroesSource(borutoApi = borutoApi, query = "Sa")
            assertEquals<LoadResult<Int, Hero>>(
                expected = LoadResult.Page(
                    data = listOf(heroes.first(), heroes[2]),
                    prevKey = null,
                    nextKey = null
                ),
                actual = heroSource.load(
                    LoadParams.Refresh(
                        key = null,
                        loadSize = 3,
                        placeholdersEnabled = false
                    )
                )
            )
        }

    @Test
    fun `Search api with empty hero name, assert empty heroes list and LoadResult_Page`() =
        runTest {
            val heroSource = SearchHeroesSource(borutoApi = borutoApi, query = "")
            val loadResult = heroSource.load(
                LoadParams.Refresh(
                    key = null,
                    loadSize = 3,
                    placeholdersEnabled = false
                )
            )

            val result = borutoApi.searchHeroes("").heroes

            assertTrue { result.isEmpty() }
            assertTrue { loadResult is LoadResult.Page }
        }

    @Test
    fun `Search api with non_existing hero name, assert empty heroes list and LoadResult_Page`() =
        runTest {
            val heroSource = SearchHeroesSource(borutoApi = borutoApi, query = "Unknown")
            val loadResult = heroSource.load(
                LoadParams.Refresh(
                    key = null,
                    loadSize = 3,
                    placeholdersEnabled = false
                )
            )

            val result = borutoApi.searchHeroes("Unknown").heroes

            assertTrue { result.isEmpty() }
            assertTrue { loadResult is LoadResult.Page }
        }

}












