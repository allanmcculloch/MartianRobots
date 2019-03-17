package com.allanmcculloch.martianrobots.model

data class Coordinate(
    var x : Int = 0,
    var y : Int = 0) {

    override fun toString(): String =
        "$x $y"
}