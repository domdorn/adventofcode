package com.dominikdorn.adventofcode.v2021.day02

final case class Movement(direction: Direction, steps: Int)

object Movement {
  def parse(movement: String): Movement =
    movement.split(" ").toSeq match {
      case Seq("forward", i) => Movement(Direction.Forward, i.toInt)
      case Seq("down", i) => Movement(Direction.Down, i.toInt)
      case Seq("up", i) => Movement(Direction.Up, i.toInt)
      case _ =>
        throw new IllegalArgumentException(s"Unknown movement: $movement")
    }

  def parseMovements(movements: Seq[String]): Seq[Movement] =
    movements.filter(_.trim.contains(" ")).map(Movement.parse)
}
