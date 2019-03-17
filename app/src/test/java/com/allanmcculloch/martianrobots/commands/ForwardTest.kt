package com.allanmcculloch.martianrobots.commands

import com.allanmcculloch.martianrobots.model.Coordinate
import com.allanmcculloch.martianrobots.model.Orientation
import junit.framework.Assert.assertEquals
import org.junit.Test

class ForwardTest : BaseCommandTest() {
    private val command = Forward()

    @Test
    fun moveForwardNorth() {
       val robot = setupRobot(Coordinate(0,1),Orientation.North)

        robot.executeCommand(command)

        assertEquals(2, robot.position.y)
        assertEquals(0, robot.position.x) // unchanged
        assertEquals(Orientation.North, robot.orientation) // unchanged
    }

    @Test
    fun moveForwardSouth() {
        val robot = setupRobot(Coordinate(0,2),Orientation.South)

        robot.executeCommand(command)

        assertEquals(1, robot.position.y)
        assertEquals(0, robot.position.x) // unchanged
        assertEquals(Orientation.South, robot.orientation) // unchanged
    }

    @Test
    fun moveForwardEast() {
        val robot = setupRobot(Coordinate(3,1),Orientation.East)

        robot.executeCommand(command)

        assertEquals(4, robot.position.x)
        assertEquals(1, robot.position.y) // unchanged
        assertEquals(Orientation.East, robot.orientation) // unchanged
    }

    @Test
    fun moveForwardWest() {
        val robot = setupRobot(Coordinate(3,1),Orientation.West)

        robot.executeCommand(command)

        assertEquals(2, robot.position.x)
        assertEquals(1, robot.position.y) // unchanged
        assertEquals(Orientation.West, robot.orientation) // unchanged
    }
}
