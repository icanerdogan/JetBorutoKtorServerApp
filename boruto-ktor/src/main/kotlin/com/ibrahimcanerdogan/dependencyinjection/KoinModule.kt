package com.ibrahimcanerdogan.dependencyinjection

import com.ibrahimcanerdogan.repository.HeroRepository
import com.ibrahimcanerdogan.repository.HeroRepositoryImpl
import org.koin.dsl.module

val koinModule = module {
    single<HeroRepository> {
        HeroRepositoryImpl()
    }
}