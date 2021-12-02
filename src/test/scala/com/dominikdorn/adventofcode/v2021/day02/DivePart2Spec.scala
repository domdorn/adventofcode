package com.dominikdorn.adventofcode.v2021.day02

import zio.test._

object DivePart2Spec extends DefaultRunnableSpec {
  override def spec: ZSpec[TestEnvironment, Any] = suite("Day2 spec")(
    test("should correctly calculate the sample inputs") {
      for {
        n <- DivePart2.readSampleMovements
      } yield assertTrue(n == 900)
    },
    test("should correctly calculate using the exercise inputs") {
      for {
        n <- DivePart2.readExerciseMovements
      } yield assertTrue(n == 2101031224)
    }
  )
}
