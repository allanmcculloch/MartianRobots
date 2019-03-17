package com.allanmcculloch.martianrobots.providers

import com.allanmcculloch.martianrobots.model.Coordinate
import com.allanmcculloch.martianrobots.model.World

object WorldProvider {
    fun setupWorld(line: String) : World {
        val xy = line.split(" ")

        val topX = xy[0].toInt()
        val topY = xy[1].toInt()

        return World(Coordinate(0,0), Coordinate(topX, topY))
    }
}