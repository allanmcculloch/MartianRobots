package com.allanmcculloch.martianrobots.providers

import com.allanmcculloch.martianrobots.model.Coordinate
import com.allanmcculloch.martianrobots.model.Orientation
import com.allanmcculloch.martianrobots.model.World
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RobotProviderTest {
    lateinit var robotProvider: RobotProvider
    var world : World = World(Coordinate(0,0), Coordinate(5,3))

    @Before
    fun Setup() {
        robotProvider = RobotProvider(world)
    }

    @Test
    fun getsRobotEast() {
        var robot = robotProvider.createRobot("1 1 E")

        assertEquals(1, robot.positionX)
        assertEquals(1, robot.positionY)
        assertEquals(robot.orientation.toString(), Orientation.East.toString())
    }

    @Test
    fun getsRobotNorth() {
        var robot = robotProvider.createRobot("3 2 N")

        assertEquals(3, robot.positionX)
        assertEquals(2, robot.positionY)
        assertEquals(robot.orientation.toString(), Orientation.North.toString())
    }

    @Test
    fun getsRobotWest() {
        var robot = robotProvider.createRobot("0 3 W")

        assertEquals(0, robot.positionX)
        assertEquals(3, robot.positionY)
        assertEquals(robot.orientation.toString(), Orientation.West.toString())
    }

    @Test
    fun getsRobotSouth() {
        var robot = robotProvider.createRobot("3 2 S")

        assertEquals(3, robot.positionX)
        assertEquals(2, robot.positionY)
        assertEquals(robot.orientation.toString(), Orientation.South.toString())
    }
}