package com.example.mykiosk

data class MenuItem(val name: String, val description: String, val price: Int, var count: Int = 1) {

}