package com.example.numbercomposition.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameSettings(
    val maxSumValue: Int,
    val minCountOfRightAnswers: Int,
    val minPercentOfRightAnswer: Int,
    val gameTimeSeconds: Int
) : Parcelable {
    val minCountOfRightAnswersString: String
        get() = minCountOfRightAnswers.toString()

    val minPercentOfRightAnswerString: String
        get() = minPercentOfRightAnswer.toString()
}