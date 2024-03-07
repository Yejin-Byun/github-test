package com.example.testest

class Solution {
    fun solution(phone_number: String): String {
        var numStr = StringBuilder(phone_number)

        for(i in numStr.indices) {
            numStr[i] = '*'
            if(numStr.length - numStr.indexOf('*') == 4) {
                return numStr.toString()
            }
        }

        println(numStr)
        return numStr.toString()
    }
}