package test

import main.PackPlanner.main
import org.junit.jupiter.api.Test

internal class PackPlannerTest {
    @Test
    fun main() {
        println("TESTING")

        val args1 = arrayOf("NATURAL,40,500.0",
                "1001,6200,30,9.653",
                "2001,7200,50,11.21")

        val args2 = arrayOf("SHORT_TO_LONG,40,500.0",
                "1001,6200,30,9.653",
                "2001,7200,50,11.21")

        val args3 = arrayOf("LONG_TO_SHORT,40,500.0",
                "1001,6200,30,9.653",
                "2001,7200,50,11.21")
        println("NATURAL")
        main(args1)
        println("SHORT_TO_LONG")
        main(args2)
        println("LONG_TO_SHORT")
        main(args3)
    }
}