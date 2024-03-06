package com.example.testest

open class Calculator(num1: Int, num2: Int) {
    var num1: Int
    var num2: Int

    init {
        this.num1 = num1
        this.num2 = num2
    }

    open fun operation() {
        println("연산을 수행합니다 . . .")
    }
}