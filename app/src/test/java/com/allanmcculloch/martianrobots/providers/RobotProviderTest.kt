package com.allanmcculloch.martianrobots.providers

import com.allanmcculloch.martianrobots.commands.Forward
import com.allanmcculloch.martianrobots.commands.Left
import com.allanmcculloch.martianrobots.commands.Right
import com.allanmcculloch.martianrobots.model.Orientation
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Test

class RobotProviderTest {

    @Test
    fun getsRobotEast() {
        var robot = RobotProvider.createRobot("1 1 E")

        assertEquals(1, robot.position.x)
        assertEquals(1, robot.position.y)
        assertEquals(robot.orientation.toString(), Orientation.East.toString())
    }

    @Test
    fun getsRobotNorth() {
        var robot = RobotProvider.createRobot("3 2 N")

        assertEquals(3, robot.position.x)
        assertEquals(2, robot.position.y)
        assertEquals(robot.orientation.toString(), Orientation.North.toString())
    }

    @Test
    fun getsRobotWest() {
        var robot = RobotProvider.createRobot("0 3 W")

        assertEquals(0, robot.position.x)
        assertEquals(3, robot.position.y)
        assertEquals(robot.orientation.toString(), Orientation.West.toString())
    }

    @Test
    fun getsRobotSouth() {
        var robot = RobotProvider.createRobot("3 2 S")

        assertEquals(10, robot.position.x)
        assertEquals(10, robot.position.y)
        assertEquals(robot.orientation.toString(), Orientation.South.toString())
    }



}