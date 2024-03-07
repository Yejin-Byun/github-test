package com.example.testest

abstract class AbstractOperation(num1: Int, num2: Int) {
    var num1: Int
    var num2: Int

    init {
        this.num1 = num1
        this.num2 = num2
    }

    open fun operation() { // 추상 메소드

    }
}