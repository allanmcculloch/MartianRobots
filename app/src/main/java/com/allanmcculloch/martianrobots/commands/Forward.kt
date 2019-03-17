package com.allanmcculloch.martianrobots.commands

import com.allanmcculloch.martianrobots.model.Orientation
import com.allanmcculloch.martianrobots.model.Robot

class Forward : BaseCommand() {
    override fun execute(robot: Robot) {
        when (robot.orientation) {
            Orientation.East -> robot.position.x++
            Orientation.North -> robot.position.y++
            Orientation.South -> robot.position.y--
            Orientation.West -> robot.position.x--
        }
    }

    companion object {
        const val CommandCode = 'F'
    }
}