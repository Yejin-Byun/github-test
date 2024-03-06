package com.example.testest

class AddOperation(num1: Int, num2: Int) : Calculator(num1, num2) {
    override fun operation() {
        println("$num1 + $num2 = ${num1+num2}")
        println()
    }
}