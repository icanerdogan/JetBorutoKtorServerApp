package com.ibrahimcanerdogan.repository

import com.ibrahimcanerdogan.model.APIResponse
import com.ibrahimcanerdogan.model.Hero

interface HeroRepository {

    val heroes: Map<Int, List<Hero>>

    val page1: List<Hero>
    val page2: List<Hero>
    val page3: List<Hero>
    val page4: List<Hero>
    val page5: List<Hero>

    suspend fun getAllHeroes(page: Int = 1): APIResponse
    suspend fun searchHeroes(name: String?): APIResponse

}