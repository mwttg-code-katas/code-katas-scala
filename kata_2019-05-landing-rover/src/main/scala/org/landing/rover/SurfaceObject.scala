package org.landing.rover

// This is some Enum alike stuff

sealed trait SurfaceObject

case object Obstacle extends SurfaceObject

case object Clearance extends SurfaceObject

case object Unknown extends SurfaceObject
