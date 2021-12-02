package com.dominikdorn.adventofcode.v2021.day02

sealed trait Direction
case object Direction {
  case object Up extends Direction
  case object Down extends Direction
  case object Forward extends Direction
}
