package com.example.compositionofthenumber.domain.usecases

import com.example.compositionofthenumber.domain.entity.Question
import com.example.compositionofthenumber.domain.repository.GameRepository

class GenerateQuestionsUseCase(
    private val repository: GameRepository
) {
    operator fun invoke(maxSumValue: Int): Question {
        return repository.generateQuestion(maxSumValue, COUNT_OF_OPTIONS)
    }

    private companion object {
        private const val COUNT_OF_OPTIONS = 0
    }
}