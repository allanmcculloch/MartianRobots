package com.allanmcculloch.martianrobots.model

import com.allanmcculloch.martianrobots.commands.BaseCommand

class Robot(
    private var position : Coordinate,
    var orientation : Orientation,
    var isLost : Boolean = false,
    var world : World) {

    var positionX : Int
        set(newX) {
            if (isLost)
                return

            updatePosition(Coordinate(newX, position.y))
        }
        get() = position.x

    var positionY : Int
        set(newY) {
            if (isLost)
                return

            updatePosition(Coordinate(position.x, newY))
        }
        get() = position.y

    private fun updatePosition(newPosition : Coordinate) {
        if (newPosition.x > world.topBound.x || newPosition.y > world.topBound.y) {
            robotLost()
            return
        }

        position = newPosition
    }

    private fun robotLost() {
        if(world.isPositionScented(position)) {
            return
        }

        world.scentedPoints.add(position)
        isLost = true
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
