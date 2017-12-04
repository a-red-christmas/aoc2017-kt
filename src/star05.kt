import java.lang.Math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

fun main(args: Array<String>) {
    val start = 19 //Integer.parseInt(args[0])
    val sqrtStart = roundUp(sqrt(start.toDouble()))
    val size = if (sqrtStart % 2 == 0) sqrtStart + 1 else sqrtStart
    val center = roundUp(size / 2.0) // q1, q2 == center, center
    val last = (pow((size).toDouble(), 2.0)).toInt()
    val bottomLeft = last - size + 1
    val topLeft = bottomLeft - size + 1
    val topRight = topLeft - size + 1
    val first = topRight - size + 2
    val position = size % (last - start) // TODO: nope. Not right yet. 1:30 am going to bed.

    // TODO: find p1, p2 from start.
    /*
    1,1 ... 1,size
    .
    .
    .
    size,1 ... size,size
     */
    when {
        start > bottomLeft -> println("[$size, $position]")
        start > topLeft -> println("[$position, 1]")
        start > topRight -> println("[1, $position]")
        else -> println("[$position, $size]")
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