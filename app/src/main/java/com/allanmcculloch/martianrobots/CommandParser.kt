package com.allanmcculloch.martianrobots

import com.allanmcculloch.martianrobots.model.Robot
import com.allanmcculloch.martianrobots.model.World
import com.allanmcculloch.martianrobots.providers.CommandProvider
import com.allanmcculloch.martianrobots.providers.RobotProvider
import com.allanmcculloch.martianrobots.providers.WorldProvider
import java.lang.Exception

class CommandParser {
    val maxCommandLength = 100

    lateinit var world : World
    private lateinit var robotProvider : RobotProvider
    private var currentRobot : Robot? = null

    fun Execute(input : String) : String {
        val commandLines = input.split('\n')

        commandLines.forEachIndexed { index, line ->
            try {
                if (line.isEmpty() || line.isBlank()) {
                    // continue
                }
                else if (line.length > maxCommandLength) {
                    throw Exception("Command length more than 100 characters at line ${index+1}")
                }
                else if (! ::world.isInitialized) {
                    val newWorld = WorldProvider.setupWorld(line)
                    this.robotProvider = RobotProvider(newWorld)
                    world = newWorld
                }
                else if (currentRobot != null) {
                    val commands = CommandProvider.getCommandList(line)
                    currentRobot?.executeCommands(commands)
                    currentRobot = null
                }
                else { // create robot
                    val robot = robotProvider.createRobot(line)
                    this.world.robots.add(robot)
                    currentRobot = robot
                }
            }
            catch(e : Exception) {
                throw Exception("Failed at line ${index +1} - ${e?.message}")
            }
        }

        return world.robotStatus()
    }
}
