package com.ibrahimcanerdogan.jetboruto.data.remote

import com.ibrahimcanerdogan.jetboruto.domain.model.APIResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BorutoAPI {

    @GET("/boruto/heroes")
    suspend fun getAllHeroes(
        @Query("page") page: Int = 1
    ): APIResponse

    @GET("/boruto/heroes/search")
    suspend fun searchHeroes(
        @Query("name") name: String
    ): APIResponse

}