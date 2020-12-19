package main

import main.utils.SortOrder
import java.util.*

/**
 * main.Pack class
 */
class Pack(id: Int) {
    private var packId = 1 // Package ID
    var packLength = 0
        set(packLength) {
            field = if (this.packLength > packLength) this.packLength else packLength
        }
    private var packWeight = 0f
    private var packQuantity = 0
    private val itemArrayList = ArrayList<Item>()
    var items = Stack<Item>() // List of Items

    fun getPackWeight(): Float {
        return packWeight
    }

    private fun setPackWeight(packWeight: Float) {
        this.packWeight += packWeight
    }

    fun getPackQuantity(): Int {
        return packQuantity
    }

    private fun setPackQuantity(packQuantity: Int) {
        this.packQuantity += packQuantity
    }

    fun wrap(subItem: Item): Boolean {
        if (packQuantity + subItem.quantity <= maxPieces
                && packWeight + subItem.weight <= maxWeight) {
            packLength = subItem.length
            setPackWeight(subItem.weight)
            setPackQuantity(subItem.quantity)
            itemArrayList.add(subItem)
            return true
        }
        return false
    }

    fun markDone() {
        // all the items are ready
        var sum = 1
        var preItem: Item? = null
        for (i in itemArrayList.indices) {
            val item = itemArrayList[i]
            if (preItem == null) {
                preItem = item
                continue
            }
            if (item.id == preItem.id) {
                sum++
            } else {
                val totalItem = Item(preItem.id, preItem.length, sum, preItem.weight)
                items.push(totalItem)
                sum = 1
            }
            preItem = item
            if (i == itemArrayList.size - 1) {
                val totalItem = Item(preItem.id, preItem.length, sum, preItem.weight)
                items.push(totalItem)
            }
        }
        //        itemArrayList.clear();
    }

    override fun toString(): String {

        // [item id],[item length],[item quantity],[piece weight]
        // [item id],[item length],[item quantity],[piece weight]
        // main.Pack Length: [pack length], main.Pack Weight: [pack weight]
        val log = StringBuilder("Pack Number: $packId\r\n")
        for (x in items) {
            log.append(x.toString())
        }
        val info = """
            Pack Length: $packLength, Pack Weight: ${getPackWeight()}
            
            """.trimIndent()
        log.append(info)
        return log.toString()
    }

    companion object {
        var sortOrder = SortOrder.NATURAL
        var maxPieces = Int.MAX_VALUE
        var maxWeight = Float.MAX_VALUE
    }

    init {
        if (id < 0) {
            throw Exception("Argument Exception")
        }
        packId = id
    }
}