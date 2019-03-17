package com.allanmcculloch.martianrobots.commands

import com.allanmcculloch.martianrobots.model.Orientation
import com.allanmcculloch.martianrobots.model.Robot

class Left : BaseCommand() {
    override fun execute(robot: Robot) {
        when (robot.orientation) {
            Orientation.East -> robot.orientation = Orientation.North
            Orientation.North -> robot.orientation = Orientation.West
            Orientation.South -> robot.orientation = Orientation.East
            Orientation.West -> robot.orientation = Orientation.South
        }
    }

    companion object {
        const val CommandCode = 'L'
    }
}