package com.example.numbercomposition.domain.usecases

import com.example.numbercomposition.domain.entity.Question
import com.example.numbercomposition.domain.repository.GameRepository

class GenerateQuestionUseCase(private val repository: GameRepository) {
    operator fun invoke(maxSumOfValue: Int): Question {
        return repository.generateGameSettingsQuestion(maxSumOfValue, COUNT_OF_OPTIONS)
    }

    private companion object {
        private const val COUNT_OF_OPTIONS = 6
    }
}