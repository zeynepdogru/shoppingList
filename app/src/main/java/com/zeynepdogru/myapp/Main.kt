package com.zeynepdogru.myapp

import java.lang.IllegalArgumentException

fun toDouble(variable: String): Double {

    print(variable)
    return readLine()?.trim()?.toDoubleOrNull() ?: run {
        println("Geçerli bir sayısal değer giriniz!")
        toDouble(variable)
    }
}


fun addItemToShoppingList(shoppingList: ShoppingList) {

    while(true) {
        println("Ürün tipini seçin (1: Food, 2: Cloth):")
        val type = readLine()!!

        if (type == "1") {
            println("Food adını girin: ")
            val name = readLine()!!

            val price = toDouble("Fiyatını girin:\n ")


            val weight = toDouble("Ağırlığını girin:\n").toString()

            shoppingList.addItem(Food(name, price, weight))
            println("${name} listenize başarıyla eklendi!")
            break

        }
        else if (type == "2") {
            println("Cloth adını girin: ")
            val name = readLine()!!

            println("Fiyatını girin: ")
            val price = readLine()!!.toDouble()

            println("Tipini girin: ")
            val kind = readLine()!!

            shoppingList.addItem(Cloth(name, price, kind))
            println("${name} listenize başarıyla eklendi!")
            break
        }
        else
            println("Geçersiz tip seçimi, tekrar deneyiniz.")
    }
}


fun main() {
    val shoppingList = ShoppingList()
    while (true) {
        println("**Alışveriş Listesi**\n 1-Add Item\n 2-Display Items\n 3-Delete Item\n 4-Exit")
        println("Yapmak istediğiniz işlemi seçiniz: ")
        when (readLine()!!) {
            "1" -> addItemToShoppingList(shoppingList)
            "2" -> {
                println("Alışveriş listeniz:")
                shoppingList.displayItems()
            }
            "3" -> {
                println("Silmek istediğiniz ürünün numarasını girin:")
                val index = readLine()!!.toIntOrNull() ?: 0
                shoppingList.deleteItem(index)
            }
            "4" -> return
            else -> println("Geçersiz seçim, lütfen tekrar deneyin.")
        }
    }
}