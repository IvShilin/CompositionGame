package com.example.compositionofthenumber.domain.entity

data class GameResult(
    val winner : Boolean,
    val countOfRightAnswers : Int,
    val countOfRightQuestions: Int,
    val gameSettings: GameSettings
)