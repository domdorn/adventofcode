package com.dominikdorn.adventofcode.v2021.day02

import zio.test._
import zio._

object DiveSpec extends DefaultRunnableSpec {
  override def spec: ZSpec[TestEnvironment, Any] = suite("Day2 spec")(
    test("should correctly calculate the sample inputs") {
      for {
        n <- Dive.readSampleMovements
      } yield assertTrue(n == 150)
    },
    test("should correctly calculate using the exercise inputs") {
      for {
        n <- Dive.readExerciseMovements
      } yield assertTrue(n == 2102357)
    },


  )
}
