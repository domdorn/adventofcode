package com.dominikdorn.adventofcode.v2021.day02

import com.dominikdorn.adventofcode.v2021.AdventCommons
import zio.ZIO

object Dive {
  sealed trait Direction
  case object Direction {
    case object Up extends Direction
    case object Down extends Direction
    case object Forward extends Direction
  }
  final case class Movement(direction: Direction, steps: Int)

  final case class Position(horizontal: Int, depth: Int) {
    def move(movement: Movement): Position = movement.direction match {
      case Direction.Up => Position(horizontal, depth - movement.steps)
      case Direction.Down => Position(horizontal, depth + movement.steps)
      case Direction.Forward => Position(horizontal + movement.steps, depth)
    }

    def distanceTravelled: Int = horizontal * depth
  }
  object Position {
    val initial: Position = Position(0,0)
  }

  def parseMovement(movement: String): Movement = {
    movement.split(" ").toSeq match {
      case Seq("forward", i) => Movement(Direction.Forward, i.toInt)
      case Seq("down", i) => Movement(Direction.Down, i.toInt)
      case Seq("up", i) => Movement(Direction.Up, i.toInt)
      case _ => throw new IllegalArgumentException(s"Unknown movement: $movement")
    }
  }

  def parseMovements(movements: Seq[String]): Seq[Movement] = movements.filter(_.trim.contains(" ")).map(parseMovement)

  def calcPosition(movements: Seq[Movement]): Position = movements.foldLeft(Position.initial)((position, movement) => position.move(movement))

  def readSampleMovements = for {
    rawInput <- AdventCommons.readFile(Dive.getClass, "sampleMovements.txt").useNow
    parsed <- ZIO.attempt(parseMovements(rawInput))
    position = calcPosition(parsed)
  } yield position.distanceTravelled



}
