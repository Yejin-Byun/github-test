package com.example.testest

class MultiplyOperation(num1: Int, num2: Int): AbstractOperation(num1, num2) {
    override fun operation() {
        println("$num1 * $num2 = ${num1*num2}")
        println()
    }
}