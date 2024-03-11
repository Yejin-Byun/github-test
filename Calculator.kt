package com.example.testest

open class Calculator(num1: Int, num2: Int): AbstractOperation(num1, num2) {
    override fun operation() {
        println("연산을 수행합니다 . . .")
    }
}