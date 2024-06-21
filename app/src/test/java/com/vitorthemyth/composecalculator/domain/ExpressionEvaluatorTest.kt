package com.vitorthemyth.composecalculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ExpressionEvaluatorTest{

    private lateinit var evaluator : ExpressionEvaluator

    @Test
    fun `simple expression properly evaluated`(){
        evaluator = ExpressionEvaluator(
            listOf(
                ExpressionPart.Number(4.0),
                ExpressionPart.Op(Operation.ADD),
                ExpressionPart.Number(5.0),
                ExpressionPart.Op(Operation.SUBTRACT),
                ExpressionPart.Number(3.0),
                ExpressionPart.Op(Operation.MULTIPLY),
                ExpressionPart.Number(5.0),
                ExpressionPart.Op(Operation.DIVIDE),
                ExpressionPart.Number(3.0)
            )
        )
        4+5-3*5/3
        assertThat(evaluator.evaluate()).isEqualTo(4)
    }

    @Test
    fun `Expressions with decimals properly evaluated`(){
        evaluator = ExpressionEvaluator(
            listOf(
                ExpressionPart.Number(4.5),
                ExpressionPart.Op(Operation.ADD),
                ExpressionPart.Number(5.5),
                ExpressionPart.Op(Operation.SUBTRACT),
                ExpressionPart.Number(3.5),
                ExpressionPart.Op(Operation.MULTIPLY),
                ExpressionPart.Number(5.5),
                ExpressionPart.Op(Operation.DIVIDE),
                ExpressionPart.Number(3.5)
            )
        )
        assertThat(evaluator.evaluate()).isEqualTo(4.5)
    }
}