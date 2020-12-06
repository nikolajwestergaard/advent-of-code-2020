package dk.versio.aoc2020

import scala.io.Source

object Dec06 extends App {

  def loadAnswers(file: String) = Source.fromResource(file).getLines()
    .foldLeft(List(List[String]()))((list, line) =>
      if (line.isEmpty) list :+ List() else list.init :+ (list.last :+ line))

  def loadCustomAnswers(file: String) = loadAnswers(file).map(_.flatMap(_.toList).distinct)
  def loadCustomAnswersCommon(file: String) = loadAnswers(file).map(_.reduce(_.intersect(_)))

  println(Dec06.loadCustomAnswers("06.txt").map(_.length).sum)
  println(Dec06.loadCustomAnswersCommon("06.txt").map(_.length).sum)
}