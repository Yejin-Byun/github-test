package com.example.testest

class SubtractOperation(num1: Int, num2: Int): AbstractOperation(num1, num2) {
    override fun operation() {
        if(num1 > num2) {
            println("$num1 - $num2 = ${num1-num2}")
            println()
        }

        if(num1 < num2) {
            println("$num2 - $num1 = ${num2-num1}")
            println()
        }

    }
}