package dk.versio.aoc2020

import scala.io.Source

object Dec02 extends App {

  def getValidCombination(file: String, validator: (String, Char, Int, Int) => Boolean): List[Any] = Source
    .fromResource(file)
    .getLines()
    .filter(p => {
      val parts = p.split(" ")
      val mm = parts(0).split("-").map(_.toInt)
      validator(parts(2), parts(1).replace(":", "").head, mm(0), mm(1))
    }).toList

  def sledRentingStrategy(text: String, char: Char, p1: Int, p2: Int): Boolean = {
    val count = text.count(_ == char)
    count >= p1 && count <= p2
  }

  def tobogganStrategy(text: String, char: Char, p1: Int, p2: Int): Boolean =
    f"${text(p1 - 1)}${text(p2 - 1)}".count(_ == char) == 1

  println(getValidCombination("02.txt", sledRentingStrategy).length)
  println(getValidCombination("02.txt", tobogganStrategy).length)
}
