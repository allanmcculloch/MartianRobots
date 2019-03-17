package com.allanmcculloch.martianrobots.model

import com.allanmcculloch.martianrobots.commands.BaseCommand

class Robot(
    var position : Coordinate,
    var orientation : Orientation) {

    fun executeCommand(command : BaseCommand) : Robot {
        command.execute(this)
        return this
    }

    override fun toString() =
        "$position $orientation"
}
