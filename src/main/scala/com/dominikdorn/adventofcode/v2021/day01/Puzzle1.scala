package com.dominikdorn.adventofcode.v2021.day01
import com.dominikdorn.adventofcode.v2021.AdventCommons
import zio._

object Puzzle1 extends ZIOAppDefault {

  def countNumberOfIncrementsSliding2(measurements: List[Int]): Int = {
    val transformed = measurements

    transformed.tail
      .zip(transformed)
      .map { case (a, b) =>
        if (a > b) 1 else 0
      }
      .sum

  }

  def countNumberOfIncrementsSliding3(measurements: List[Int]): Int = {

    val windows =
      measurements.tail.zip(measurements).zip(measurements.tail.tail).map {
        case ((a, b), c) => a + b + c
      }

    countNumberOfIncrementsSliding2(windows)
  }

  def getTestNumbers = AdventCommons
    .readFile(Puzzle1.getClass, "puzzle1Input.txt")
    .map(l => l.map(_.toInt))

  override def run: ZIO[ZEnv with ZIOAppArgs, Any, Any] =
    for {
      _ <- ZIO.debug("test123")
    } yield ()
}
