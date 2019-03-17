package com.allanmcculloch.martianrobots.commands

import com.allanmcculloch.martianrobots.model.Orientation
import com.allanmcculloch.martianrobots.model.Robot

class Right : BaseCommand() {
    override fun execute(robot: Robot) {
        when (robot.orientation) {
            Orientation.East -> robot.orientation = Orientation.South
            Orientation.North -> robot.orientation = Orientation.East
            Orientation.South -> robot.orientation = Orientation.West
            Orientation.West -> robot.orientation = Orientation.North
        }
    }

    companion object {
        const val CommandCode = 'R'
    }
}