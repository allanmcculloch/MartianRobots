package com.allanmcculloch.martianrobots.providers

import com.allanmcculloch.martianrobots.model.World
import junit.framework.Assert
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

        Assert.assertEquals(5, world?.topBound?.x)
        Assert.assertEquals(3, world?.topBound?.y)
    }

    @Test
    fun bottomBoundsZero() {

        Assert.assertEquals(0, world?.bottomBound?.x)
        Assert.assertEquals(0, world?.bottomBound?.y)
    }

    @Test
    fun robotsListInitiallyZero() {

        Assert.assertEquals(0, world?.robots?.count())
    }
}