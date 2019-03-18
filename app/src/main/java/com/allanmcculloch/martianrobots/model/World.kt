package com.allanmcculloch.martianrobots.model

class World(
    var bottomBound : Coordinate,
    var topBound : Coordinate,
    var robots : MutableList<Robot> = mutableListOf(),
    var scentedPoints : MutableList<Coordinate> = mutableListOf()
) {
    fun robotStatus(): String {
        var output : StringBuilder = StringBuilder()

        robots.forEach {
            output.append("$it\n")
        }

        return output.toString()
    }

    fun isPositionScented(position : Coordinate) : Boolean {
        return scentedPoints.contains(position)
    }
}