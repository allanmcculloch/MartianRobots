package com.allanmcculloch.martianrobots.providers

import com.allanmcculloch.martianrobots.commands.BaseCommand
import com.allanmcculloch.martianrobots.commands.Forward
import com.allanmcculloch.martianrobots.commands.Left
import com.allanmcculloch.martianrobots.commands.Right

object CommandProvider {
    fun getCommandList(line : String) : List<BaseCommand> {

        val commands : MutableList<BaseCommand> = mutableListOf()

        line.forEach {
           commands.add(getCommand(it))
        }
        return commands
    }

    fun getCommand(commandCode : Char) : BaseCommand =
        when (commandCode) {
            Left.CommandCode -> Left()
            Right.CommandCode -> Right()
            Forward.CommandCode -> Forward()
            else -> throw Exception("Invalid command")
        }
}