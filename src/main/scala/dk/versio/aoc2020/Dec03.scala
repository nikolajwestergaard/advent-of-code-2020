package dk.versio.aoc2020

import scala.io.Source

object Dec03 extends App {

  def getMap(file: String, width: Int): List[List[Boolean]] =
    Source.fromResource(file).getLines().toList.map(_.repeat(width)).map(_.map(_ == '#').toList)

  def countTrees(file: String, width: Int = 100, down: Int = 1, left: Int = 3): Long = getMap(file, width)
    .zipWithIndex
    .foldLeft(0) {
      case (n, (level, idx)) if idx % down == 0 && level((idx / down) * left) => n + 1
      case (n, _) => n
    }.toLong

  def countAlternatives(file: String, width: Int = 100): Long =
    List((1, 1), (1, 3), (1, 5), (1, 7), (2, 1)).map(p => countTrees(file, width, p._1, p._2)).product

  println(countTrees("03.txt"))
  println(countAlternatives("03.txt"))
}