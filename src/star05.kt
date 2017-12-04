import java.lang.Math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

fun main(args: Array<String>) {
    val start = 23 //Integer.parseInt(args[0])
    val sqrtStart = roundUp(sqrt(start.toDouble()))
    val size = if (sqrtStart % 2 == 0) sqrtStart + 1 else sqrtStart
    val center = roundUp(size / 2.0) // q1, q2 == center, center
    val lastNumber = (pow((size).toDouble(), 2.0)).toInt()

    // TODO: find p1, p2 from start.

    println(size.toString() + ": [" + center.toString() + ", " + center.toString() + "], last: " + lastNumber.toString() + ", diff: " + (lastNumber - start).toString())
}

fun roundUp(num : Double) : Int {
    val rounded = num.roundToInt()

    return if (num > rounded) rounded + 1 else rounded
}