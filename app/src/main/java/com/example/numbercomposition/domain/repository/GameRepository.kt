package com.example.numbercomposition.domain.repository

import com.example.numbercomposition.domain.entity.GameSettings
import com.example.numbercomposition.domain.entity.Level
import com.example.numbercomposition.domain.entity.Question

interface GameRepository {
    fun getGameSettings(level: Level): GameSettings
    fun generateGameSettingsQuestion(maxSumOfValue: Int, countOfOptions: Int): Question
}