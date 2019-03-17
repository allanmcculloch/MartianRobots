package com.allanmcculloch.martianrobots.commands

import com.allanmcculloch.martianrobots.model.Coordinate
import com.allanmcculloch.martianrobots.model.Orientation
import com.allanmcculloch.martianrobots.model.Robot

open class BaseCommandTest {
    fun setupRobot(position : Coordinate, orientation : Orientation) : Robot =
        Robot(position, orientation)
}