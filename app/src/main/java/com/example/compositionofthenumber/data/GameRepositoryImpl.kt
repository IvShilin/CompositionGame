package com.example.compositionofthenumber.data

import com.example.compositionofthenumber.domain.entity.GameSettings
import com.example.compositionofthenumber.domain.entity.Level
import com.example.compositionofthenumber.domain.entity.Question
import com.example.compositionofthenumber.domain.repository.GameRepository
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

object GameRepositoryImpl : GameRepository {
    private const val MIN_SUM_VALUE = 2
    private const val MIN_SUM_ANSWER = 1

    override fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question {
        val sum = Random.nextInt(MIN_SUM_VALUE, maxSumValue + 1)
        val visibleNumber = Random.nextInt(MIN_SUM_ANSWER, sum)
        val options = HashSet<Int>()
        val rightAnswer = sum - visibleNumber
        options.add(rightAnswer)
        val from = max(rightAnswer - countOfOptions, MIN_SUM_VALUE)
        val to = min(maxSumValue - 1, rightAnswer + countOfOptions)
        while (options.size < countOfOptions) {
            options.add(Random.nextInt(from, to))
        }
        return Question(sum, visibleNumber, options.toList())
    }

    override fun getGameSettings(level: Level): GameSettings {
        return when (level) {
            Level.TEST -> {
                GameSettings(
                    10,
                    3,
                    50,
                    8
                )
            }
            Level.EASY -> {
                GameSettings(
                    30,
                    5,
                    50,
                    15
                )
            }
            Level.NORMAL -> {
                GameSettings(
                    100,
                    5,
                    65,
                    10
                )
            }
            Level.HARD -> {
                GameSettings(
                    200,
                    5,
                    90,
                    5
                )
            }
        }
    }
}