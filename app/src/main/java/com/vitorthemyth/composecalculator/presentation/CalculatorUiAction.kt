package com.vitorthemyth.composecalculator.presentation

import androidx.compose.runtime.Composable
import com.vitorthemyth.composecalculator.domain.CalculatorAction

data class CalculatorUiAction(
    val text: String?,
    val highlightLevel: HighlightLevel,
    val action: CalculatorAction,
    val content: @Composable () -> Unit = {}
)

sealed interface HighlightLevel {
    object Neutral : HighlightLevel
    object SemiHighlighted : HighlightLevel
    object Highlighted : HighlightLevel
    object StronglyHighlighted : HighlightLevel
}