package com.allanmcculloch.martianrobots.commands

import com.allanmcculloch.martianrobots.model.Coordinate
import com.allanmcculloch.martianrobots.model.Orientation
import junit.framework.Assert.assertEquals
import org.junit.Test

class RightTest : BaseCommandTest() {
    private val command = Right()

    @Test
    fun rightFromNorth() {
       val robot = setupRobot(Coordinate(1,1),Orientation.North)

        robot.executeCommand(command)

        assertEquals(Orientation.East, robot.orientation)
        assertEquals(1, robot.position.y) // unchanged
        assertEquals(1, robot.position.x) // unchanged
    }

    @Test
    fun rightFromSouth() {
        val robot = setupRobot(Coordinate(1,1),Orientation.South)

        robot.executeCommand(command)

        assertEquals(Orientation.West, robot.orientation)
        assertEquals(1, robot.position.y) // unchanged
        assertEquals(1, robot.position.x) // unchanged
    }

    @Test
    fun rightFromEast() {
        val robot = setupRobot(Coordinate(1,1),Orientation.East)

        robot.executeCommand(command)

        assertEquals(Orientation.South, robot.orientation)
        assertEquals(1, robot.position.y) // unchanged
        assertEquals(1, robot.position.x) // unchanged
    }

    @Test
    fun rightFromWest() {
        val robot = setupRobot(Coordinate(1,1),Orientation.West)

        robot.executeCommand(command)

        assertEquals(Orientation.North, robot.orientation)
        assertEquals(1, robot.position.y) // unchanged
        assertEquals(1, robot.position.x) // unchanged
    }
}
