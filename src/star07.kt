fun main(args: Array<String>) {
    val input = "aa bb cc dd ee\n" +
            "aa bb cc dd aa\n" +
            "aa bb cc dd aaa"
    val rows = input.split("\n")
    var sum = 0

    for (rowString in rows) {
        val row = rowString.split(" ")

        sum += if (row.toSet().size == row.size) 1 else 0
    }

    println(sum)
}
