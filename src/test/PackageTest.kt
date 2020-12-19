package test

import main.Package
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ParameterResolutionException

internal class PackageTest {
    @Test
    fun pack() {
        val args = arrayOf("40,500.0",
                "1001,6200,30,9.653",
                "2001,7200,50,11.21")
        val mPackage = Package()
        Assertions.assertThrows(ParameterResolutionException::class.java) {
            mPackage.parseData(args)
            mPackage.pack()
        }
        val args2 = arrayOf("NATURAL,40,500.0",
                "6200,30,9.653",
                "2001,7200,50,11.21")
        val mPackage2 = Package()
        Assertions.assertThrows(Exception::class.java) {
            mPackage2.parseData(args2)
            mPackage2.pack()
        }
    }
}