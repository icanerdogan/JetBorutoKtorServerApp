package com.ibrahimcanerdogan.jetboruto.domain.usecase

import com.ibrahimcanerdogan.jetboruto.data.repository.Repository

class SaveOnBoardingUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(completed: Boolean) {
        repository.saveOnBoardingState(completed = completed)
    }
}