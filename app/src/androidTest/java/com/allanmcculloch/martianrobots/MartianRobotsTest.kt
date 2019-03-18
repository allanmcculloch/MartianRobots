package com.allanmcculloch.martianrobots

import androidx.test.InstrumentationRegistry
import org.junit.Test
import org.junit.Assert.*

class MartianRobotsTest {
    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.allanmcculloch.martianrobots", appContext.packageName)

        //TODO: Add UITest
    }
}
