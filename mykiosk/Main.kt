package com.example.mykiosk

import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.O)
fun main() {
    val menuScreen = MenuScreen()
    menuScreen.displayMenu()
}

class MenuScreen { // 첫 메인 화면 출력
    var money = 10000
    private val menuScreen = this

    private val shoppingCart = ShoppingCart
    private val burgerMenu = BurgerMenu()
    private val dessertMenu = DessertMenu()
    private val drinkMenu = DrinkMenu()
    private val beerMenu = BeerMenu()

    init {
        shoppingCart.initMoney(money)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun displayMenu() {
        println("[ SHAKESHACK MENU ]")
        displayMenuItem("1. Burgers", "|", "앵거스 비프 통살을 다져만든 버거")
        displayMenuItem("2. Forzen Custard", "|", "매장에서 신선하게 만드는 아이스크림")
        displayMenuItem("3. Drinks", "|", "매장에서 직접 만드는 음료")
        displayMenuItem("4. Beer", "|", "뉴욕 브루클린 브루어리에서 양조한 맥주")

        println("\n[ ORDER MENU ]")
        displayMenuItem("5. Order", "|", "장바구니 확인 및 주문")
        displayMenuItem("6. EXIT", "|", "프로그램 종료")

        print("\n>> ")
        val Input = readln()
        when (Input) {
            "1" -> burgerMenu.displayBurgers()
            "2" -> dessertMenu.displayDessert()
            "3" -> drinkMenu.displayDrinks()
            "4" -> beerMenu.displayBeers()
            "5" -> shoppingCart.displayItems()
            "6" -> println("프로그램을 종료합니다 . . .")
        }
    }

    private fun displayMenuItem(item: String, price: String, description: String) {
        // 문자열 포맷팅을 사용하여 출력 간격 맞춤
        println("%-20s %-5s %s".format(item, price, description))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun cartQ(menuItem: MenuItem?) {
        menuItem?.let { item ->
            println("\n상품명: ${item.name} | 가격: ${item.price}원 \n> 위 상품을 장바구니에 추가하시겠습까? \n 1. 확인    2. 취소")

            print(">> ")
            when (readlnOrNull()) {
                "1" -> {
                    shoppingCart.addItem(item)
                    println("\'${item.name}\'를 장바구니에 추가했습니다!\n")
                    displayMenu()
                }
                "2" -> {
                    println("")
                }
            }
        }
    }
}

