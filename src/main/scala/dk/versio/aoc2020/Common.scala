package dk.versio.aoc2020

import scala.io.Source

object Common {

  def loadNumbers(name: String): List[Int] = Source
    .fromResource(name)
    .getLines()
    .map(_.toInt)
    .toList

}
