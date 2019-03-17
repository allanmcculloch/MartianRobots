package com.allanmcculloch.martianrobots.model

import com.allanmcculloch.martianrobots.commands.BaseCommand

class Robot(
    var position : Coordinate,
    var orientation : Orientation,
    var isLost : Boolean = false) {

    fun executeCommand(command : BaseCommand) : Robot {
        command.execute(this)
        return this
    }

    fun executeCommands(commands : List<BaseCommand>) : Robot {
        commands.forEach {
            executeCommand(it)
        }
        return this
    }

    override fun toString() : String {

        val lostText = if (isLost) " LOST" else ""

        return "$position $orientation$lostText"
    }

}
