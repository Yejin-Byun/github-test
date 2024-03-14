package com.example.mykiosk

import android.os.Build
import androidx.annotation.RequiresApi

class DrinkMenu {
    @RequiresApi(Build.VERSION_CODES.O)
    fun displayDrinks() {
        val menuScreen = MenuScreen()

        println("\n[ Drinks MENU ]")
        val drinks = mapOf(
            "1" to MenuItem("Cola", "시원한 탄산 콜라", 1500),
            "2" to MenuItem("Cider", "시원한 탄산 사이다", 1500),
            "3" to MenuItem("Fanta", "시원한 탄산 환타", 1500),
            "4" to MenuItem("Milkshake", "부드럽고 달콤한 밀크쉐이크", 2000),
            "0" to "BACK              | 뒤로가기"
        )

        drinks.forEach { (key, value) ->
            if (value is MenuItem) {
                displayMenuItem("$key. ${value.name}", "| W ${value.price} |", value.description)
            } else {
                println("$key. $value")
            }
        }

        print("\n>> ")
        val input = readlnOrNull()
        when (input.toString()) {
            in "1".."4" -> {
                val menuItem = drinks[input] as? MenuItem
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