package com.allanmcculloch.martianrobots

import com.allanmcculloch.martianrobots.model.Robot
import com.allanmcculloch.martianrobots.model.World
import com.allanmcculloch.martianrobots.providers.CommandProvider
import com.allanmcculloch.martianrobots.providers.RobotProvider
import com.allanmcculloch.martianrobots.providers.WorldProvider
import java.lang.Exception

class ExecuteCommands {
    val maxCommandLegth = 100

    lateinit var robotProvider : RobotProvider
    lateinit var world : World

    fun Execute(input : String) : String {

        val commandLines = input.split('\n')
        var currentRobot : Robot? = null

        commandLines.forEachIndexed { index, line ->
            try {
                if (line.isNullOrEmpty() || line.isBlank()) {
                    // continue
                }
                else if (line.length > maxCommandLegth) {
                    throw Exception("Command length more than 100 characters at $index")
                }
                else if (! ::world.isInitialized) {
                    var newWorld = WorldProvider.setupWorld(line)
                    robotProvider = RobotProvider(newWorld)
                    world = newWorld
                }
                else if (currentRobot != null) {
                    val commands = CommandProvider.getCommandList(line)

                    currentRobot?.executeCommands(commands)

                    currentRobot = null
                }
                else { // create robot
                    val robot = robotProvider.createRobot(line)

                    world.robots.add(robot)

                    currentRobot = robot
                }
            }
            catch(e : Exception) {
                throw Exception("Failed at line $index", e)
            }
        }

        return world.robotStatus()
    }
}
