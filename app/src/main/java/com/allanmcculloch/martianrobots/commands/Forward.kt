package com.allanmcculloch.martianrobots.commands

import com.allanmcculloch.martianrobots.model.Orientation
import com.allanmcculloch.martianrobots.model.Robot

class Forward : BaseCommand() {
    override fun execute(robot: Robot) {
        when (robot.orientation) {
            Orientation.East -> robot.updateX(robot.position.x++)
            Orientation.North -> robot.updateY(robot.position.y++)
            Orientation.South -> robot.updateY(robot.position.y--)
            Orientation.West -> robot.updateX(robot.position.x--)
        }
    }

    companion object {
        const val CommandCode = 'F'
    }
}