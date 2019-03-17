package com.allanmcculloch.martianrobots.model

import junit.framework.Assert.*
import org.junit.Test

class RobotTest {
    var world : World = World(Coordinate(0,0),Coordinate(5,3))

    @Test
    fun getStringReturnsCorrectly() {
        var robot = Robot(Coordinate(4,3), Orientation.West, false, world)

        assertEquals("4 3 W", robot.toString())
    }

    @Test
    fun getStringReturnsCorrectlyIfLost() {
        var robot = Robot(Coordinate(1,2), Orientation.East, true, world)

        assertEquals("1 2 E LOST", robot.toString())
    }

    @Test
    fun lostIfMovesOutOfBoundsX() {
        var robot = Robot(Coordinate(5,3), Orientation.East, false, world)

        assertFalse(robot.isLost)

        robot.updateX(robot.position.x + 1)

        assertTrue(robot.isLost)
    }

    @Test
    fun lostIfMovesOutOfBoundsY() {
        var robot = Robot(Coordinate(1,3), Orientation.North, false, world)

        assertFalse(robot.isLost)

        robot.updateY(robot.position.y + 1)

        assertTrue(robot.isLost)
    }
}