package com.allanmcculloch.martianrobots.providers

import com.allanmcculloch.martianrobots.model.World
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class WorldProviderTest {
    lateinit var world : World

    @Before
    fun setup() {
        world = WorldProvider.setupWorld("5 3")
    }

    @Test
    fun getWorldTopBoundsSetCorrectly() {
        assertEquals(5, world?.topBound?.x)
        assertEquals(3, world?.topBound?.y)
    }

    @Test
    fun bottomBoundsZero() {
        assertEquals(0, world?.bottomBound?.x)
        assertEquals(0, world?.bottomBound?.y)
    }

    @Test
    fun robotsListInitiallyZero() {
        assertEquals(0, world?.robots?.count())
    }
}