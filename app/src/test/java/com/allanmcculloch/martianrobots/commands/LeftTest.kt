package com.allanmcculloch.martianrobots.commands

import com.allanmcculloch.martianrobots.model.Coordinate
import com.allanmcculloch.martianrobots.model.Orientation
import junit.framework.Assert.assertEquals
import org.junit.Test

class LeftTest : BaseCommandTest() {
    private val command = Left()

    @Test
    fun leftFromNorth() {
       val robot = setupRobot(Coordinate(1,1),Orientation.North)

        robot.executeCommand(command)

        assertEquals(Orientation.West, robot.orientation)
        assertEquals(1, robot.positionY) // unchanged
        assertEquals(1, robot.positionX) // unchanged
    }

    @Test
    fun leftFromSouth() {
        val robot = setupRobot(Coordinate(1,1),Orientation.South)

        robot.executeCommand(command)

        assertEquals(Orientation.East, robot.orientation)
        assertEquals(1, robot.positionY) // unchanged
        assertEquals(1, robot.positionX) // unchanged
    }

    @Test
    fun leftFromEast() {
        val robot = setupRobot(Coordinate(1,1),Orientation.East)

        robot.executeCommand(command)

        assertEquals(Orientation.North, robot.orientation)
        assertEquals(1, robot.positionY) // unchanged
        assertEquals(1, robot.positionX) // unchanged
    }

    @Test
    fun leftFromWest() {
        val robot = setupRobot(Coordinate(1,1),Orientation.West)

        robot.executeCommand(command)

        assertEquals(Orientation.South, robot.orientation)
        assertEquals(1, robot.positionY) // unchanged
        assertEquals(1, robot.positionX) // unchanged
    }
}
