import java.lang.Math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

fun main(args: Array<String>) {
    val start = 17 //Integer.parseInt(args[0])
    val sqrtStart = roundUp(sqrt(start.toDouble()))
    val size = if (sqrtStart % 2 == 0) sqrtStart + 1 else sqrtStart
    val center = roundUp(size / 2.0) // q1, q2 == center, center
    val last = (pow((size).toDouble(), 2.0)).toInt()
    val bottomLeft = last - size + 1
    val topLeft = bottomLeft - size + 1
    val topRight = topLeft - size + 1
    val first = topRight - size + 2

    // TODO: find p1, p2 from start.
    /*
    1,1 ... 1,size
    .
    .
    .
    size,1 ... size,size
     */
    when {
        start > bottomLeft -> println("b[$size, ${if (last - start == 0) size else last - start}]")
        start > topLeft -> println("l[${if (bottomLeft - start == 0) size else bottomLeft - start + 1}, 1]")
        start > topRight -> println("t[1, ${topLeft - start + 1}]")
        else -> println("r[${topRight - start + 1}, $size]")
    }

    println(size.toString() + ": [" + center.toString() + ", " + center.toString() + "], br: "
            + last.toString()
            + ", bl: " + bottomLeft.toString()
            + ", tl: " + topLeft.toString()
            + ", tr: " + topRight.toString()
            + ", first: " + first.toString())
}

fun roundUp(num : Double) : Int {
    val rounded = num.roundToInt()

    return if (num > rounded) rounded + 1 else rounded
}