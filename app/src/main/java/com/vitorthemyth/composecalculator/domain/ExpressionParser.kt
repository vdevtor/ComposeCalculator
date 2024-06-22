package com.vitorthemyth.composecalculator.domain

import java.lang.IllegalArgumentException

class ExpressionParser(
    private val calculation: String
) {

    fun parser(): List<ExpressionPart> {
        val result = mutableListOf<ExpressionPart>()
        var i = 0

        while (i < calculation.length) {
            val curChar = calculation[i]
            when {
                curChar in operationSymbols -> {
                    result.add(
                        ExpressionPart.Op(operationFromSymbol(curChar))
                    )
                }

                curChar.isDigit() -> {
                    i = parseNumber(i, result)
                    continue
                }

                curChar in "()" -> {
                    parseParentheses(curChar, result)
                }
            }
            i++
        }
        return result
    }

    private fun parseNumber(startIndex: Int, result: MutableList<ExpressionPart>): Int {
        var i = startIndex
        val numberAsString = buildString {
            while (i < calculation.length && calculation[i] in "0123456789.") {
                append(calculation[i])
                i++
            }
        }
        result.add(ExpressionPart.Number(numberAsString.toDouble()))

        return i
    }

    private fun parseParentheses(curChar: Char, result: MutableList<ExpressionPart>) {
        result.add(
            ExpressionPart.Parentheses(
                type = when (curChar) {
                    '(' -> ParenthesesType.OpeningType
                    ')' -> ParenthesesType.Closing
                    else -> throw IllegalArgumentException("Invalid Parentheses type")
                }
            )
        )
    }
}