package com.example.compositionofthenumber.domain.usecases

import com.example.compositionofthenumber.domain.entity.GameSettings
import com.example.compositionofthenumber.domain.entity.Level
import com.example.compositionofthenumber.domain.repository.GameRepository

class GetGameSettingsUseCase(
    private val repository: GameRepository
) {
    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}