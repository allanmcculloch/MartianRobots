package com.allanmcculloch.martianrobots.model

import junit.framework.Assert.assertEquals
import org.junit.Test

class RobotTest {

    @Test
    fun getStringReturnsCorrectly() {
        var robot = Robot(Coordinate(4,3), Orientation.West)

        assertEquals("4 3 W", robot.toString())
    }

    @Test
    fun getStringReturnsCorrectlyIfLost() {
        var robot = Robot(Coordinate(1,2), Orientation.East, true)

        assertEquals("1 2 E LOST", robot.toString())
    }
}