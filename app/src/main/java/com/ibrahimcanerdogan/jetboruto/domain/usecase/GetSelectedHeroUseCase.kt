package com.ibrahimcanerdogan.jetboruto.domain.usecase

import com.ibrahimcanerdogan.jetboruto.data.repository.Repository
import com.ibrahimcanerdogan.jetboruto.domain.model.Hero

class GetSelectedHeroUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(heroId: Int): Hero {
        return repository.getSelectedHero(heroId = heroId)
    }
}