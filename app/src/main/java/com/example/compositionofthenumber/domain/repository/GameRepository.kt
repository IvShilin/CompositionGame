package com.example.compositionofthenumber.domain.repository

import com.example.compositionofthenumber.domain.entity.GameSettings
import com.example.compositionofthenumber.domain.entity.Level
import com.example.compositionofthenumber.domain.entity.Question

interface GameRepository {
    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level): GameSettings
}