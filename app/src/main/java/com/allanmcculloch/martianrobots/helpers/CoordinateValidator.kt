package com.allanmcculloch.martianrobots.helpers

object CoordinateValidator {
    private const val maxCoordinateValue = 50
    private const val minCoordinateValue = 0

    fun throwIfOutOfRange(value : Int)
    {
        if (! validateCoordinate(value)) {
            throw Exception("The value for any co-ordinate cannot be higher than 50 or lower than 0")
        }
    }
    fun validateCoordinate(value : Int) : Boolean =
        value in minCoordinateValue-1..maxCoordinateValue
}
