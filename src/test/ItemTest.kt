package test

import main.Item
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ItemTest {
    @Test
    fun testToString() {
        var out = "-1,0,0,0.0\n"
        var item = Item()
        var s = item.toString()
        Assertions.assertEquals(s, out)
        out = "1,2000,30,19.01\n"
        item = Item(1, 2000, 30, 19.01f)
        s = item.toString()
        Assertions.assertEquals(s, out)
    }
}