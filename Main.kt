package com.example.testest


fun main() {
    println("============= 계산기 프로그램 ===============")
    println("1. 더하기 연산")
    println("2. 빼기 연산")
    println("3. 곱하기 연산")
    println("4. 나누기 연산")
    println("5. 종료")

    while(true) {
        print(">>>> ")
        val calcNumber = readln()!!.toInt()
        when(calcNumber) {
            1 -> {
                print("숫자 입력: ")
                val (num1, num2) = splitNum()
                val add = AddOperation(num1, num2)
                add.operation()
            }
            2 -> {
                print("숫자 입력: ")
                val (num1, num2) = splitNum()
                val sub = SubtractOperation(num1, num2)
                sub.operation()
            }
            3 -> {
                print("숫자 입력: ")
                val (num1, num2) = splitNum()
                val mul = MultiplyOperation(num1, num2)
                mul.operation()
            }
            4 -> {
                print("숫자 입력: ")
                val (num1, num2) = splitNum()
                val div = DivideOperation(num1, num2)
                div.operation()
            }
            5 -> {
                println("프로그램을 종료합니다 . . .")
                break
            }
        }
    }
}

fun splitNum(): Pair<Int, Int> {
    val input = readLine()
    val (num1, num2) = input?.split(" ")?.map { it.toInt() }?.run {
        if (size == 2) Pair(get(0), get(1)) else Pair(0, 0)
    } ?: Pair(0, 0)
    return Pair(num1, num2)
}