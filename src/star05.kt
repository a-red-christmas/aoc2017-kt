import java.lang.Math.abs
import java.lang.Math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

fun main(args: Array<String>) {
    println(findManhattanDistance(368078))
}

fun findManhattanDistance(start: Int) : Int {
    val sqrtStart = roundUp(sqrt(start.toDouble()))
    val size = if (sqrtStart % 2 == 0) sqrtStart + 1 else sqrtStart
    val center = roundUp(size / 2.0) // q1, q2 == center, center
    val last = (pow((size).toDouble(), 2.0)).toInt()
    val bottomLeft = last - size + 1
    val topLeft = bottomLeft - size + 1
    val topRight = topLeft - size + 1

    /*
    1,1 ... size,1
    .
    .
    .
    1,size ... size,size
     */
    val location =  when {
        start >= bottomLeft -> Pair(size - (last - start), size)
        start >= topLeft -> Pair(1, size - (bottomLeft - start))
        start >= topRight -> Pair(topLeft - start + 1, 1)
        else -> Pair(size, topRight - start + 1)
    }

    return abs(location.first - center) + abs(location.second - center)
}

fun roundUp(num : Double) : Int {
    val rounded = num.roundToInt()

    return if (num > rounded) rounded + 1 else rounded
}