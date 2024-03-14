package com.example.mykiosk

import android.os.Build
import androidx.annotation.RequiresApi

class DessertMenu {
    @RequiresApi(Build.VERSION_CODES.O)
    fun displayDessert() {
        val menuScreen = MenuScreen()

        println("\n[ Forzen Custard MENU ]")
        val desserts = mapOf(
            "1" to MenuItem("Shack Attack", "진한 초콜릿 커스터드", 6200),
            "2" to MenuItem("Honey Butter", "바닐라 커스타드에 허니 버터 소스", 6200),
            "3" to MenuItem("Better 2Gether", "바닐라와 초콜릿 커스터드 반반", 6200),
            "4" to MenuItem("Shack-ffogato", "바닐라 커스터드에 커피 카라멜", 6200),
            "5" to MenuItem("Crunch Star", "달콤 바삭한 초콜릿 토피 콘크리트", 6200),
            "0" to "BACK              | 뒤로가기"
        )

        desserts.forEach { (key, value) ->
            if (value is MenuItem) {
                displayMenuItem("$key. ${value.name}", "| W ${value.price} |", value.description)
            } else {
                println("$key. $value")
            }
        }

        print("\n>> ")
        val input = readlnOrNull()
        when (input.toString()) {
            in "1".."5" -> {
                val menuItem = desserts[input] as? MenuItem
                if(menuItem != null) {
                    menuScreen.cartQ(menuItem)
                }
            }
            "0" -> menuScreen.displayMenu()
        }
    }

    private fun displayMenuItem(item: String, price: String, description: String) {
        // 문자열 포맷팅을 사용하여 출력 간격 맞춤
        println("%-20s %-5s %s".format(item, price, description))
    }
}