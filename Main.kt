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
        var calcNumber = readln()!!.toInt()
        when(calcNumber) {
            1 -> {
                print("숫자 입력: ")
                var (num1, num2) = readln()!!.split(" ").map{ it.toInt() }
                var add = AddOperation(num1, num2)
                add.operation()
            }
            2 -> {
                print("숫자 입력: ")
                var (num1, num2) = readln()!!.split(" ").map{ it.toInt() }
                var sub = SubtractOperation(num1, num2)
                sub.operation()
            }
            3 -> {
                print("숫자 입력: ")
                var (num1, num2) = readln()!!.split(" ").map{ it.toInt() }
                var mul = MultiplyOperation(num1, num2)
                mul.operation()
            }
            4 -> {
                print("숫자 입력: ")
                var (num1, num2) = readln()!!.split(" ").map{ it.toInt() }
                var div = DivideOperation(num1, num2)
                div.operation()
            }
            5 -> {
                println("프로그램을 종료합니다 . . .")
                break
            }
        }
    }
}