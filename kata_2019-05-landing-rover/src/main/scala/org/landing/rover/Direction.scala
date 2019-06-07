package org.landing.rover

// This is some Enum alike stuff

sealed trait Direction

case object North extends Direction

case object East extends Direction

case object South extends Direction

case object West extends Direction
