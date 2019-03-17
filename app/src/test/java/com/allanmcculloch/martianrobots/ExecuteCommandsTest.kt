package com.allanmcculloch.martianrobots

import junit.framework.Assert.assertEquals
import org.junit.Test

class ExecuteCommandsTest {

    @Test
    fun executeCommands() {


        var output = ExecuteCommands().Execute(testData)

        assertEquals(expectedOutput, output)
    }


    var testData ="""
5 3
1 1 E
RFRFRFRF

3 2 N
FRRFLLFFRRFLL

0 3 W
LLFFFLFLFL
"""

    var expectedOutput ="""11E
33NLOST
23S
"""

}


