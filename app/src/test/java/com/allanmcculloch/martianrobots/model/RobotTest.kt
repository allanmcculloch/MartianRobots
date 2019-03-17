package com.allanmcculloch.martianrobots.model

import junit.framework.Assert.assertEquals
import org.junit.Test

class RobotTest {

    @Test
    fun getStringReturnsCorrectly() {
        var robot = Robot(Coordinate(4,3), Orientation.West)

        assertEquals("4 3 W", robot.toString())
    }
}