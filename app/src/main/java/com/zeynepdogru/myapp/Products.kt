package com.zeynepdogru.myapp

open class Item (val name:String, val price:Double)

class Food(name: String, price:Double, val weight:String): Item(name,price)

class Cloth(name:String, price:Double, val type:String):Item(name, price)