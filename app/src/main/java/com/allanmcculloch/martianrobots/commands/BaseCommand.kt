package com.allanmcculloch.martianrobots.commands

import com.allanmcculloch.martianrobots.model.Robot

abstract class BaseCommand {
    abstract fun execute(robot: Robot)
}