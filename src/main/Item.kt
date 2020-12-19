package main

import main.utils.SortOrder

/**
 * main.Item class
 */
class Item @JvmOverloads constructor(id: Int = -1, length: Int = 0, quantity: Int = 0, weight: Float = 0f) : Comparable<Item> {
    var id = -1 // Item ID
    var length = 0 // Item Length (mm)
    var quantity = 0 // Sum
    var weight = 0f // (kg, the weight of one item)
    override fun compareTo(o: Item): Int {
        var result = 0
        if (sortOrder === SortOrder.SHORT_TO_LONG) {
            result = if (length > o.length) 1 else -1
        } else if (sortOrder === SortOrder.LONG_TO_SHORT) {
            result = if (length < o.length) 1 else -1
        }
        return result
    }


    override fun toString(): String {
        return """
            $id,$length,$quantity,$weight
            
            """.trimIndent()
    }

    companion object {
        var sortOrder = SortOrder.NATURAL
    }

    init {
        this.id = id
        this.length = length
        this.quantity = quantity
        this.weight = weight
    }
}