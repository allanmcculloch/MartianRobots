package com.allanmcculloch.martianrobots.model

import junit.framework.Assert.*
import org.junit.Before
import org.junit.Test

class RobotTest {
    lateinit var world : World

    @Before
    fun setup() {
        world = World(Coordinate(0,0),Coordinate(5,3))
    }

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

        robot.positionX++

        assertTrue(robot.isLost)
    }

    @Test
    fun lostIfMovesOutOfBoundsY() {
        var robot = Robot(Coordinate(1,3), Orientation.North, false, world)

        assertFalse(robot.isLost)

        robot.positionY++

        assertTrue(robot.isLost)
    }

    @Test
    fun leavesScentWhenMovesOutOfBoundsY() {
        val initialCoordinate = Coordinate(1,3)
        var robot = Robot(initialCoordinate, Orientation.North, false, world)

        assertFalse(robot.isLost)

        robot.positionY++

        assertTrue(world.isPositionScented(initialCoordinate))
    }

    @Test
    fun leavesScentWhenMovesOutOfBoundsX() {
        val initialCoordinate = Coordinate(5,3)
        var robot = Robot(initialCoordinate, Orientation.East, false, world)

        assertFalse(robot.isLost)

        robot.positionX++

        assertTrue(world.isPositionScented(initialCoordinate))
    }

    @Test
    fun doesNotMoveOutOfBoundsIfScent() {
        val initialCoordinate = Coordinate(5,3)
        var robot = Robot(initialCoordinate, Orientation.East, false, world)

        assertFalse(robot.isLost)
        robot.positionX++

        assertTrue(robot.isLost)
        assertTrue(world.isPositionScented(initialCoordinate))

        var robot2 = Robot(initialCoordinate, Orientation.East, false, world)

        assertFalse(robot2.isLost)
        robot.positionX++
        assertFalse(robot2.isLost)
    }
}