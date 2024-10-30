package com.ibrahimcanerdogan.jetboruto.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.ibrahimcanerdogan.jetboruto.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    useCases: UseCases
): ViewModel() {
    val getAllHeroes = useCases.getAllHeroesUseCase()
}