package com.example.mykiosk
import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

object ShoppingCart { // 싱글톤 객체 (Object)
    private val items = mutableListOf<MenuItem>()
    private var userMoney = 0
    private val menuScreen = MenuScreen()

    @RequiresApi(Build.VERSION_CODES.O)
    val currentDateTime = LocalDateTime.now()
    @RequiresApi(Build.VERSION_CODES.O)
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    @RequiresApi(Build.VERSION_CODES.O)
    val formattedDateTime = currentDateTime.format(formatter)


    @RequiresApi(Build.VERSION_CODES.O)
    val closingTime = LocalDateTime.of(currentDateTime.toLocalDate(), LocalTime.of(23, 0))
    @RequiresApi(Build.VERSION_CODES.O)
    val hour = currentDateTime.hour
    @RequiresApi(Build.VERSION_CODES.O)
    val minute = currentDateTime.minute


    fun initMoney(money : Int) {
        userMoney = money
    }

    fun addItem(item: MenuItem) {
        val existItem = items.find { it.name == item.name }
        if (existItem != null) {
            existItem.count++
        } else {
            items.add(item)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun displayItems() {
        println("[ 장바구니 ]")
        items.forEachIndexed { index, item ->
            val formattedItem = String.format("%d. %-15s | 가격: %-6s 원 | 수량: %d",
                index + 1, item.name, item.price, item.count)
            println(formattedItem)
            }
        println("\n[ Total ]\n총 금액: ${totalCost()} 원")
        println("\n1. 주문하기       |        2. 메뉴판 보기")

        when(readln()) {
            "1" -> doOrder()
            "2" -> menuScreen.displayMenu()
        }
    }

    private fun totalCost(): Int {
        var totalCost = 0
        items.forEach() { item ->
            totalCost += item.price * item.count
        }
        return totalCost
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun doOrder() {
        var totalCost = totalCost()

        if(currentDateTime.isAfter(closingTime)) {
            println("현재 시각은 ${hour}시 ${minute}분입니다.\n은행 점검 시간은 오후11시 ~ 오전 12시까지  이므로 결제할 수 없습니다.")
        }

        if (totalCost > userMoney) {
            println("현재 잔액은 ${userMoney}원으로 ${(userMoney-totalCost)*-1}원이 부족해서 주문할 수 없습니다.")
        } else {
            println("\n주문이 완료되었습니다! (완료 시간: $formattedDateTime)")
            userMoney -= totalCost
            println("남은 잔액: $userMoney 원")
            clearCart()
        }
    }
    private fun clearCart() {
        items.clear()
    }
}