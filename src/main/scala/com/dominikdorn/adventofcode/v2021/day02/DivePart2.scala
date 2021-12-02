package com.dominikdorn.adventofcode.v2021.day02

import com.dominikdorn.adventofcode.v2021.AdventCommons
import zio.ZIO

object DivePart2 {

  final case class Position(horizontal: Int, depth: Int, aim: Int) {
    def move(movement: Movement): Position = movement.direction match {
      case Direction.Up => Position(horizontal, depth, aim - movement.steps)
      case Direction.Down => Position(horizontal, depth, aim + movement.steps)
      case Direction.Forward =>
        Position(
          horizontal + movement.steps,
          depth + (aim * movement.steps),
          aim
        )
    }

    def distanceTravelled: Int = horizontal * depth
  }
  object Position {
    val initial: Position = Position(0, 0, 0)
  }



  def calcPosition(movements: Seq[Movement]): Position =
    movements.foldLeft(Position.initial)((position, movement) =>
      position.move(movement)
    )

  def readSampleMovements = for {
    rawInput <- AdventCommons
      .readFile(DivePart1.getClass, "sampleMovements.txt")
      .useNow
    parsed <- ZIO.attempt(Movement.parseMovements(rawInput))
    position = calcPosition(parsed)
  } yield position.distanceTravelled

  def readExerciseMovements = for {
    rawInput <- AdventCommons
      .readFile(DivePart1.getClass, "exerciseMovements.txt")
      .useNow
    parsed <- ZIO.attempt(Movement.parseMovements(rawInput))
    position = calcPosition(parsed)
  } yield position.distanceTravelled

}
