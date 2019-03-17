package com.allanmcculloch.martianrobots

import com.allanmcculloch.martianrobots.model.Robot
import com.allanmcculloch.martianrobots.model.World
import com.allanmcculloch.martianrobots.providers.CommandProvider
import com.allanmcculloch.martianrobots.providers.RobotProvider
import com.allanmcculloch.martianrobots.providers.WorldProvider

class ExecuteCommands() {
    var world : World? = null

    fun Execute(input : String) : String {

        val commandLines = input.split('\n')
        var currentRobot : Robot? = null
        world = null

        commandLines.forEachIndexed { index, line ->
            if (line.isNullOrEmpty() || line.isBlank()) {
               // continue
            }
            else if (world == null) {
                world = WorldProvider.setupWorld(line)
            }
            else if (currentRobot != null) {
                val commands = CommandProvider.getCommandList(line)

                currentRobot?.executeCommands(commands)

                currentRobot= null
            }
            else { // create robot
                val robot = RobotProvider.createRobot(line)

                world?.robots?.add(robot)

                currentRobot = robot
            }
        }

        return world?.robotStatus() ?: ""
    }
}
