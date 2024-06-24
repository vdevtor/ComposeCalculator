package com.vitorthemyth.composecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.vitorthemyth.composecalculator.presentation.CalculatorScreen
import com.vitorthemyth.composecalculator.ui.theme.MaterialCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Constants.BASE_URL
        setContent {
            MaterialCalculatorTheme {
                CalculatorScreen()
            }
        }
    }
}