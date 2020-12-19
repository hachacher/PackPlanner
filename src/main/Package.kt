package main

import main.utils.SortOrder
import org.junit.jupiter.api.extension.ParameterResolutionException
import java.util.*

/**
 *  Package class
 * takes a list of items and sorts them into several packs
 */
class Package {
    private val packArrayList = ArrayList<Pack?>()
    private val itemArrayList = ArrayList<Item>()

    @Throws(Exception::class)
    fun parseData(args: Array<String>) {
        for (i in args.indices) {
            val s = args[i].split(",".toRegex()).toTypedArray()
            if (i == 0) {
                parsePackInfo(s)
            } else {
                parseItemInfo(s)
            }
        }
        orderItem()
    }

    private fun orderItem() {
        Item.Companion.sortOrder = sortOrder
        when (sortOrder) {
            SortOrder.SHORT_TO_LONG, SortOrder.LONG_TO_SHORT -> Collections.sort(itemArrayList)
            SortOrder.NATURAL -> {
            }
            else -> {
            }
        }
    }
    @Throws(ParameterResolutionException::class)
    private fun parsePackInfo(s: Array<String>) {
        if (s.size < 3) {
            throw ParameterResolutionException("Argument Exception")
        }
        for (i in s.indices) {
            val str = s[i]
            if (0 == i) {
                parseOrder(str)
            } else if (1 == i) {
                Pack.Companion.maxPieces = str.toInt()
            } else if (2 == i) {
                Pack.Companion.maxWeight = str.toFloat()
            }
        }
    }

    @Throws(ParameterResolutionException::class)
    private fun parseOrder(s: String) {
        if (SHORT_TO_LONG.equals(s, ignoreCase = true)) {
            sortOrder = SortOrder.SHORT_TO_LONG
        } else if (LONG_TO_SHORT.equals(s, ignoreCase = true)) {
            sortOrder = SortOrder.LONG_TO_SHORT
        } else if (NATURAL.equals(s, ignoreCase = true)) {
            sortOrder = SortOrder.NATURAL
        } else {
            sortOrder = SortOrder.NATURAL
            throw ParameterResolutionException("Unknown main.Pack Sort Order")
        }
    }

    @Throws(ParameterResolutionException::class)
    private fun parseItemInfo(s: Array<String>) {
        if (s.size < 3) {
            throw ParameterResolutionException("Argument Exception")
        }
        var id = -1
        var length = 0
        var quantity = 0
        var weight = 0.0f
        for (i in s.indices) {
            val str = s[i]
            if (0 == i) {
                id = str.toInt()
            } else if (1 == i) {
                length = str.toInt()
            } else if (2 == i) {
                quantity = str.toInt()
            } else if (3 == i) {
                weight = str.toFloat()
            }
        }
        itemArrayList.add(Item(id, length, quantity, weight))
    }

    fun pack() {
        generatePacks()
        showDetail()
    }

    /**
     * put items to packs
     */
    private fun generatePacks() {
        var packId = 1
        Pack.Companion.sortOrder = sortOrder
        var pack: Pack? = null
        try {
            pack = Pack(packId)
            for (item in itemArrayList) {
                for (j in 0 until item.quantity) {
                    val subItem = Item(item.id, item.length, 1, item.weight)
                    if (pack!!.wrap(subItem)) {
                        //item can be put in pack
                        continue
                    } else {
                        pack.markDone()
                        packArrayList.add(pack)
                        packId++
                        pack = Pack(packId)
                        pack.wrap(subItem)
                    }
                }
            }
            pack!!.markDone()
            packArrayList.add(pack)
            itemArrayList.clear()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * display package info
     */
    private fun showDetail() {
        for (pack in packArrayList) {
            println(pack.toString())
        }
    }

    companion object {
        var sortOrder = SortOrder.NATURAL
        const val NATURAL = "NATURAL"
        const val SHORT_TO_LONG = "SHORT_TO_LONG"
        const val LONG_TO_SHORT = "LONG_TO_SHORT"
    }
}