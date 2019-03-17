package com.allanmcculloch.martianrobots.model

class World {
    var bottomBoundX : Int = 0
    var bottomBoundY : Int = 0
    var topBoundX : Int  = 0
    var topBoundY : Int = 0
    var robots = mutableListOf<Robot>()
    var scentedPoints = mutableListOf<Coordinate>()
}