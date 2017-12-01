fun main(args: Array<String>) {
    val input = args[0]
    var last = atoi(lastElement(input))
    var sum = 0

    for (n in input) {
        val current = atoi(n)

        if (current == last)
            sum += last

        last = current
    }

    println(sum)
}

fun lastElement(s: String) : Char {
    return s[s.length - 1]
}

fun atoi(a: Char): Int {
    return a.toInt() - 48
}
