package com.example.numbercomposition.presentation

import android.content.Context
import android.content.res.ColorStateList
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.numbercomposition.R
import com.example.numbercomposition.domain.entity.GameResult


interface OnOptionClickListener {
    fun onOptionClick(option: Int)
}

@BindingAdapter("resultSmile")
fun bindingResultSmile(imageView: ImageView, winner: Boolean) {
    imageView.setBackgroundResource(getSmileResId(winner))
}

private fun getSmileResId(winner: Boolean): Int {
    return if (winner) {
        R.drawable.ic_smile
    } else {
        R.drawable.ic_sad_smile
    }
}

@BindingAdapter("requiredAnswers")
fun bindingRequiredAnswers(textView: TextView, count: Int) {
    textView.text = String.format(textView.context.getString(R.string.required_answers), count)
}

@BindingAdapter("scorePlayer")
fun bindingScorePlayer(textView: TextView, score: Int) {
    textView.text = String.format(textView.context.getString(R.string.your_score), score)
}

@BindingAdapter("requiredPercentage")
fun bindingRequiredPercentage(textView: TextView, percentage: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.required_percents),
        percentage
    )
}

@BindingAdapter("rightAnswersPercentage")
fun bindingRightAnswersPercentage(textView: TextView, gameResult: GameResult) {
    textView.text = String.format(
        textView.context.getString(R.string.score_percentage),
        getPercentOfRightAnswers(gameResult)
    )
}

private fun getPercentOfRightAnswers(gameResult: GameResult) = with(gameResult) {
    if (countOfQuestions == 0) {
        0
    } else {
        ((gameResult.countOfRightAnswers / gameResult.countOfQuestions) * 100)
            .toString()
    }
}

@BindingAdapter("numberToString")
fun bindNumberToString(textView: TextView, number: Int) {
    textView.text = number.toString()
}

@BindingAdapter("enoughCountOfRightAnswers")
fun bindEnoughCountOfRightAnswers(textView: TextView, enough: Boolean) {
    textView.setTextColor(getColorByState(textView.context, enough))
}

@BindingAdapter("enoughPercentOfRightAnswers")
fun bindEnoughPercentOfRightAnswers(progressBar: ProgressBar, enough: Boolean) {
    progressBar.progressTintList = ColorStateList.valueOf(
        getColorByState(
            progressBar.context,
            enough
        )
    )
}

private fun getColorByState(context: Context, state: Boolean): Int {
    return if (state) {
        ContextCompat.getColor(context, android.R.color.holo_green_light)
    } else {
        ContextCompat.getColor(context, android.R.color.holo_red_light)
    }
}

@BindingAdapter("onOptionClickListener")
fun bindOnOptionClickListener(textView: TextView, clickListener: OnOptionClickListener) {
    textView.setOnClickListener {
        clickListener.onOptionClick(textView.text.toString().toInt())
    }
}