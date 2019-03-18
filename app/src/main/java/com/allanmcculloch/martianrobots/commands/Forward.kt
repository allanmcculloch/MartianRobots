package com.allanmcculloch.martianrobots.commands

import com.allanmcculloch.martianrobots.model.Orientation
import com.allanmcculloch.martianrobots.model.Robot

class Forward : BaseCommand() {
    override fun execute(robot: Robot) {
        when (robot.orientation) {
            Orientation.East -> robot.positionX++
            Orientation.North -> robot.positionY++
            Orientation.South -> robot.positionY--
            Orientation.West -> robot.positionX--
        }
    }

    companion object {
        const val CommandCode = 'F'
    }
}