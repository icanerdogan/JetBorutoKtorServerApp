package com.ibrahimcanerdogan.jetboruto.domain.usecase

import androidx.paging.PagingData
import com.ibrahimcanerdogan.jetboruto.data.repository.Repository
import com.ibrahimcanerdogan.jetboruto.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class GetAllHeroesUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<PagingData<Hero>> {
        return repository.getAllHeroes()
    }
}