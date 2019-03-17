package com.allanmcculloch.martianrobots.model

class World(
    var bottomBound : Coordinate? = null,
    var topBound : Coordinate? = null,
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
}