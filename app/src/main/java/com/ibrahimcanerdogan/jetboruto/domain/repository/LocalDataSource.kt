package com.ibrahimcanerdogan.jetboruto.domain.repository

import com.ibrahimcanerdogan.jetboruto.domain.model.Hero

interface LocalDataSource {
    suspend fun getSelectedHero(heroId: Int): Hero
}