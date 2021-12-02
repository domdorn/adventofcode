package com.dominikdorn.adventofcode.v2021.day01

import zio._
import zio.test._

object Puzzle1Spec extends DefaultRunnableSpec {

  val sampleNumbers = List(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)

  def spec =
    suite("Puzzle1Spec")(
      testM("easy numbers") {
        for {
          _ <- ZIO.unit
          numbers = List(1, 2, 3, 4, 5)
          count = Puzzle1.countNumberOfIncrementsSliding2(numbers)

        } yield assertTrue(count == 4)
      },
      testM("sample numbers") {
        for {
          _ <- ZIO.unit
          numbers = sampleNumbers
          count = Puzzle1.countNumberOfIncrementsSliding2(numbers)
        } yield assertTrue(count == 7)
      },
      testM("real input") {
        for {
          _ <- ZIO.unit
          numbers <- Puzzle1.getTestNumbers.useNow
          count = Puzzle1.countNumberOfIncrementsSliding2(numbers)
          _ <- ZIO.debug("count: " + count)
        } yield assertTrue(count == 1446)
      },
      testM("easy numbers sliding 3")(
        for {
          _ <- ZIO.unit
          numbers = List(1, 2, 3, 4, 5)
          count = Puzzle1.countNumberOfIncrementsSliding3(numbers)
        } yield assertTrue(count == 2)
      ),
      testM("correct value with sample numbers sliding 3")(
        for {
          _ <- ZIO.unit
          numbers = sampleNumbers
          count = Puzzle1.countNumberOfIncrementsSliding3(numbers)
        } yield assertTrue(count == 5)
      ),
      testM("correct value with real numbers sliding 3") {
        for {
          _ <- ZIO.unit
          numbers <- Puzzle1.getTestNumbers.useNow
          count = Puzzle1.countNumberOfIncrementsSliding3(numbers)
          _ <- ZIO.debug("count: " + count)
        } yield assertTrue(count == 1446)
      }
    )
}
