package com.zeynepdogru.myapp

class ShoppingList {
    private val itemList = mutableListOf<Item>()

    fun addItem(item: Item){
        itemList.add(item)
    }

    fun displayItems(){
        var counter = 1
        itemList.forEach {
            var detail = ""
            when(it){
                is Food -> detail ="Ağırlık: ${it.weight}"
                is Cloth -> detail="Tip: ${it.type}"
            }
                println("$counter.Ürün Adı: ${it.name}, Fiyat: ${it.price}, $detail")
            counter++
        }

    }

    fun deleteItem(index: Int) {
            itemList.removeAt(index - 1)
            println("${index} nolu ürün silindi.")
    }

}