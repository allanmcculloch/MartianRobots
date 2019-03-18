package com.allanmcculloch.martianrobots.helpers

object CoordinateValidator {
    private const val maxCoordinateValue = 50

    fun throwIfOutOfRange(value : Int)
    {
        if (! validateCoordinate(value)) {
            throw Exception("The value for any co-ordinate cannot be higher than 50")
        }
    }
    fun validateCoordinate(value : Int) : Boolean =
        value in 0..maxCoordinateValue
}
