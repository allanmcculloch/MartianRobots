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

        assertEquals(2, robot.positionY)
        assertEquals(0, robot.positionX) // unchanged
        assertEquals(Orientation.North, robot.orientation) // unchanged
    }

    @Test
    fun moveForwardSouth() {
        val robot = setupRobot(Coordinate(0,2),Orientation.South)

        robot.executeCommand(command)

        assertEquals(1, robot.positionY)
        assertEquals(0, robot.positionX) // unchanged
        assertEquals(Orientation.South, robot.orientation) // unchanged
    }

    @Test
    fun moveForwardEast() {
        val robot = setupRobot(Coordinate(3,1),Orientation.East)

        robot.executeCommand(command)

        assertEquals(4, robot.positionX)
        assertEquals(1, robot.positionY) // unchanged
        assertEquals(Orientation.East, robot.orientation) // unchanged
    }

    @Test
    fun moveForwardWest() {
        val robot = setupRobot(Coordinate(3,1),Orientation.West)

        robot.executeCommand(command)

        assertEquals(2, robot.positionX)
        assertEquals(1, robot.positionY) // unchanged
        assertEquals(Orientation.West, robot.orientation) // unchanged
    }
}
