package com.allanmcculloch.martianrobots.model

import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test

class WorldTest {
    @Test
    fun isScentedReturnsCorrectly() {
        var world  = World(Coordinate(0,0), Coordinate(5,3))

        world.scentedPoints = mutableListOf(Coordinate(5,3), Coordinate(4,3))

        assertTrue(world.isPositionScented(Coordinate(4,3)))
        assertTrue(world.isPositionScented(Coordinate(5,3)))
        assertFalse(world.isPositionScented(Coordinate(1,3)))
    }
}