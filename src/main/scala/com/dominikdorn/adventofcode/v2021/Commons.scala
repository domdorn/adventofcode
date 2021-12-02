package com.dominikdorn.adventofcode.v2021

import zio._

object AdventCommons {

  def readFile(
      clazz: Class[_],
      filename: String
  ): ZManaged[Any, Throwable, List[String]] = for {
    inputStream <- ZManaged.fromAutoCloseable(
      ZIO.attemptBlockingIO(clazz.getResourceAsStream(filename))
    )
    content <- ZManaged.acquireReleaseWith(
      ZIO.attempt(scala.io.Source.fromInputStream(inputStream))
    )(stream => ZIO.attempt(stream.close).ignore)
    lines <- ZManaged.attempt(content.getLines().toList)
  } yield lines

}
