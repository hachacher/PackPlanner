package main
import java.io.BufferedReader
import java.io.InputStreamReader
object PackPlanner {
    @JvmStatic
    fun main(args: Array<String>) {
        if (args.isEmpty()) {
            var list: MutableList<String> = mutableListOf<String>()
            var line: String?
            println("Pleas put in your input :")

            val br = BufferedReader(InputStreamReader(System.`in`))
            while (null != br.readLine().trim { it <= ' ' }.also { line = it } && line!!.startsWith("#")) {
                // do nothing
            }

            // if (null != (line = br.readLine().trim())) {
            // read first line
            line?.let { list.add(it) }

            var strings = line!!.split(",".toRegex()).toTypedArray()
            // System.out.println(configuration);
            // }
            while (null != br.readLine().trim { it <= ' ' }.also { line = it } && "" != line) {
                if (!line!!.startsWith("#")) {
                    line?.let { list.add(it) }
                    // System.out.println(item);
                }
            }
            try {
                val mPackage = Package()
                mPackage.parseData(list.toTypedArray())
                mPackage.pack()
                return
            } catch (e: Exception) {
                e.printStackTrace()
                println(e.message)
            }
        }
        try {
            val mPackage = Package()
            mPackage.parseData(args)
            mPackage.pack()
        } catch (e: Exception) {
            e.printStackTrace()
            println(e.message)
        }
    }
}