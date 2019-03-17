package com.allanmcculloch.martianrobots.model

import com.allanmcculloch.martianrobots.commands.BaseCommand

class Robot(
    private var _position : Coordinate,
    var orientation : Orientation,
    var isLost : Boolean = false,
    var world : World) {

    var position : Coordinate = _position.copy()

    fun updateX(newX : Int) {
        if (newX > world.topBound.x) {
            isLost = true
        }
        else {
            _position.x = newX
        }
    }

    fun updateY(newY : Int) {
        if (newY > world.topBound.y) {
            isLost = true
        }
        else {
            _position.y = newY
        }
    }

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
