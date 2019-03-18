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
        val robot = Robot(Coordinate(4,3), Orientation.West, false, world)

        assertEquals("4 3 W", robot.toString())
    }

    @Test
    fun getStringReturnsCorrectlyIfLost() {
        val robot = Robot(Coordinate(1,2), Orientation.East, true, world)

        assertEquals("1 2 E LOST", robot.toString())
    }

    @Test
    fun lostIfMovesOutOfBoundsX() {
        val robot = Robot(Coordinate(5,3), Orientation.East, false, world)

        assertFalse(robot.isLost)

        robot.positionX++

        assertTrue(robot.isLost)
    }

    @Test
    fun lostIfMovesOutOfBoundsY() {
        val robot = Robot(Coordinate(1,3), Orientation.North, false, world)

        assertFalse(robot.isLost)

        robot.positionY++

        assertTrue(robot.isLost)
    }

    @Test
    fun lostIfMovesOutOfBoundsLowerX() {
        val robot = Robot(Coordinate(0,3), Orientation.West, false, world)

        assertFalse(robot.isLost)

        robot.positionX--

        assertTrue(robot.isLost)
    }

    @Test
    fun lostIfMovesOutOfBoundsLowerY() {
        val robot = Robot(Coordinate(1,0), Orientation.South, false, world)

        assertFalse(robot.isLost)

        robot.positionY--

        assertTrue(robot.isLost)
    }

    @Test
    fun leavesScentWhenMovesOutOfBoundsY() {
        val initialCoordinate = Coordinate(1,3)
        val robot = Robot(initialCoordinate, Orientation.North, false, world)

        assertFalse(robot.isLost)

        robot.positionY++

        assertTrue(world.isPositionScented(initialCoordinate))
    }

    @Test
    fun leavesScentWhenMovesOutOfBoundsX() {
        val initialCoordinate = Coordinate(5,3)
        val robot = Robot(initialCoordinate, Orientation.East, false, world)

        assertFalse(robot.isLost)

        robot.positionX++

        assertTrue(world.isPositionScented(initialCoordinate))
    }

    @Test
    fun doesNotMoveOutOfBoundsIfScent() {
        val initialCoordinate = Coordinate(5,3)
        val robot = Robot(initialCoordinate, Orientation.East, false, world)

        assertFalse(robot.isLost)
        robot.positionX++

        assertTrue(robot.isLost)
        assertTrue(world.isPositionScented(initialCoordinate))

        val robot2 = Robot(initialCoordinate, Orientation.East, false, world)

        assertFalse(robot2.isLost)
        robot.positionX++
        assertFalse(robot2.isLost)
    }
}