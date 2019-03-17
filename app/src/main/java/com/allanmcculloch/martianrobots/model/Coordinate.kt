package com.allanmcculloch.martianrobots.model

import com.allanmcculloch.martianrobots.helpers.CoordinateValidator

data class Coordinate(
    var x : Int = 0,
    var y : Int = 0) {

    override fun toString(): String =
        "$x $y"

    init {
        CoordinateValidator.throwIfOutOfRange(x)
        CoordinateValidator.throwIfOutOfRange(y)
    }
}