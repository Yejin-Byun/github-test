package com.example.mykiosk

import android.os.Build
import androidx.annotation.RequiresApi

class BeerMenu {
    @RequiresApi(Build.VERSION_CODES.O)
    fun displayBeers() {
        val menuScreen = MenuScreen()

        println("\n[ Beers MENU ]")
        val beers = mapOf(
            "1" to MenuItem("Stella Artois", "스텔라 아르투아 맥주", 3400),
            "2" to MenuItem("Guinness Draught", "기네스 드래프트 흑맥주", 3400),
            "3" to MenuItem("Paulaner Hefe", "파울라너 헤페 맥주", 3400),
            "4" to MenuItem("Hop House 13", "홉하우스 13 맥주", 3400),
            "5" to MenuItem("Goose IPA", "구스 IPA 맥주", 3400),
            "0" to "BACK              | 뒤로가기"
        )

        beers.forEach { (key, value) ->
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
                val menuItem = beers[input] as? MenuItem
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