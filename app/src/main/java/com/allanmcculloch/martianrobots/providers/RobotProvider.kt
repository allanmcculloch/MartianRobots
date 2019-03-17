package com.allanmcculloch.martianrobots.providers
import com.allanmcculloch.martianrobots.model.Coordinate
import com.allanmcculloch.martianrobots.model.Orientation
import com.allanmcculloch.martianrobots.model.Robot
import com.allanmcculloch.martianrobots.model.World

class RobotProvider(private val world : World) {
    fun createRobot(line : String) : Robot {
        val robotCommand = line.split(" ")

        val orientation : Orientation =

        when (robotCommand[2]) {
            Orientation.East.toString() -> Orientation.East
            Orientation.West.toString() -> Orientation.West
            Orientation.North.toString() -> Orientation.North
            Orientation.South.toString() -> Orientation.South
            else -> throw Exception("Invalid orientation")
        }

        return Robot(Coordinate(robotCommand[0].toInt(), robotCommand[1].toInt()), orientation, false, world)
    }
}