package com.allanmcculloch.martianrobots

import junit.framework.Assert.assertEquals
import org.junit.Test

class CommandParserTest {
    @Test
    fun executeCommands() {
        val output = CommandParser().Execute(testData)

        assertEquals(expectedOutput, output)
    }

    var testData ="""5 3
1 1 E
RFRFRFRF

3 2 N
FRRFLLFFRRFLL

0 3 W
LLFFFLFLFL
"""

    var expectedOutput ="""1 1 E
3 3 N LOST
2 3 S
"""

}