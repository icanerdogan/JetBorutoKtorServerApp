package com.ibrahimcanerdogan.jetboruto.di

import android.content.Context
import androidx.room.Room
import com.ibrahimcanerdogan.jetboruto.data.local.BorutoDatabase
import com.ibrahimcanerdogan.jetboruto.data.repository.LocalDataSourceImpl
import com.ibrahimcanerdogan.jetboruto.domain.repository.LocalDataSource
import com.ibrahimcanerdogan.jetboruto.util.Constants.BORUTO_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): BorutoDatabase {
        return Room.databaseBuilder(
            context,
            BorutoDatabase::class.java,
            BORUTO_DATABASE
        ).build()
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(
        database: BorutoDatabase
    ): LocalDataSource {
        return LocalDataSourceImpl(
            borutoDatabase = database
        )
    }

}