package com.ibrahimcanerdogan.jetboruto.domain.usecase

import com.ibrahimcanerdogan.jetboruto.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<Boolean> {
        return repository.readOnBoardingState()
    }
}