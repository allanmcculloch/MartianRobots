package com.allanmcculloch.martianrobots.commands

import com.allanmcculloch.martianrobots.model.Coordinate
import com.allanmcculloch.martianrobots.model.Orientation
import com.allanmcculloch.martianrobots.model.Robot
import com.allanmcculloch.martianrobots.model.World

open class BaseCommandTest {
    private var world : World = World(Coordinate(0,0), Coordinate(5,3))

    fun setupRobot(position : Coordinate, orientation : Orientation) : Robot =
        Robot(position, orientation, false, world)
}