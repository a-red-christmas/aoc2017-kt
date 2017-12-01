fun main(args: Array<String>) {
    val input = args[0]
    var i = 0
    var sum = 0

    for (n in input) {
        val halfway = atoi(halfwayElement(input, i))
        val current = atoi(n)

        if (current == halfway)
            sum += halfway

        i += 1
    }

    println(sum)
}

fun halfwayElement(s: String, i: Int) : Char {
    return s[(i + s.length / 2) % s.length]
}
