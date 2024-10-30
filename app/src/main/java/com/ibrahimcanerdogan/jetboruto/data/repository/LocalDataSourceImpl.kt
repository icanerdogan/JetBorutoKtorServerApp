package com.ibrahimcanerdogan.jetboruto.data.repository

import com.ibrahimcanerdogan.jetboruto.data.local.BorutoDatabase
import com.ibrahimcanerdogan.jetboruto.domain.model.Hero
import com.ibrahimcanerdogan.jetboruto.domain.repository.LocalDataSource

class LocalDataSourceImpl(borutoDatabase: BorutoDatabase): LocalDataSource {

    private val heroDao = borutoDatabase.heroDao()

    override suspend fun getSelectedHero(heroId: Int): Hero {
        return heroDao.getSelectedHero(heroId = heroId)
    }
}