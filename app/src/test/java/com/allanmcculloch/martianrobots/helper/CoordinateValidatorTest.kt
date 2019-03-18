package com.allanmcculloch.martianrobots.helper

import com.allanmcculloch.martianrobots.helpers.CoordinateValidator
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test

class CoordinateValidatorTest {
    @Test
    fun testValid() {
        assertTrue(CoordinateValidator.validateCoordinate(50))
        assertTrue(CoordinateValidator.validateCoordinate(0))
    }

    @Test
    fun testInvalid() {
        assertFalse(CoordinateValidator.validateCoordinate(51))
        assertFalse(CoordinateValidator.validateCoordinate(1300))
        assertFalse(CoordinateValidator.validateCoordinate(-5))
    }
}