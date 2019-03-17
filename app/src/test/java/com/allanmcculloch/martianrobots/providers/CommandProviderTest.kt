package com.allanmcculloch.martianrobots.providers

import com.allanmcculloch.martianrobots.commands.Forward
import com.allanmcculloch.martianrobots.commands.Left
import com.allanmcculloch.martianrobots.commands.Right
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Test

class CommandProviderTest {

    @Test
    fun getsLeftCommandFromL() {
        var command = CommandProvider.getCommand('L')

        assertTrue(command is Left)
    }

    @Test
    fun getsRightCommandFromR() {
        var command = CommandProvider.getCommand('R')

        assertTrue(command is Right)
    }

    @Test
    fun getForwardCommandFromF() {
        var command = CommandProvider.getCommand('F')

        assertTrue(command is Forward)
    }

    @Test
    fun getsMultipleCommandsFromStringCorrectCount() {

        var commands = CommandProvider.getCommandList("LLFFFLFLFR")

        assertEquals(10, commands.count())
    }

    @Test
    fun getsMultipleCommandsFromStringCorrectTypes() {

        var commands = CommandProvider.getCommandList("LLFFFLFLFR")

        assertTrue(commands[0] is Left)
        assertTrue(commands[1] is Left)
        assertTrue(commands[2] is Forward)
        assertTrue(commands[3] is Forward)
        assertTrue(commands[4] is Forward)
        assertTrue(commands[5] is Left)
        assertTrue(commands[6] is Forward)
        assertTrue(commands[7] is Left)
        assertTrue(commands[8] is Forward)
        assertTrue(commands[9] is Right)
    }
}