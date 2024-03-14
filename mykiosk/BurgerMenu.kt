package com.example.mykiosk

import android.os.Build
import androidx.annotation.RequiresApi

class BurgerMenu {
    @RequiresApi(Build.VERSION_CODES.O)
    fun displayBurgers() {
        val menuScreen = MenuScreen()

        println("\n[ Burgers MENU ]")
        val burgers = mapOf(
            "1" to MenuItem("ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 6900),
            "2" to MenuItem("SmokeShack", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", 8900),
            "3" to MenuItem("Shroom Burger", "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거", 9400),
            "4" to MenuItem("Cheeseburger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", 6900),
            "5" to MenuItem("Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거", 5400),
            "0" to "BACK              | 뒤로가기"
        )

        burgers.forEach { (key, value) ->
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
                val menuItem = burgers[input] as? MenuItem
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