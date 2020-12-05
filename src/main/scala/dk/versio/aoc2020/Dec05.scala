package dk.versio.aoc2020

import scala.io.Source

object Dec05 extends App {

  def getBinary(str: String, zero: Char, one: Char) =
    Integer.parseInt(str.replace(zero, '0').replace(one, '1'), 2)

  def getSeat(str: String): (Int, Int, Int) = {
    val seat = (getBinary(str.substring(0, 7), 'F', 'B'), getBinary(str.substring(7), 'L', 'R'))
    (seat._1, seat._2, seat._1 * 8 + seat._2)
  }

  def getSeats(file: String) = Source.fromResource(file).getLines().map(getSeat).toList

  def fullSeatPlan =
    0.to(127).flatMap(s => 0.to(7).map(ss => (s, ss))).map(s => (s._1, s._2, s._1 * 8 + s._2)).toList

  def getMissing(file: String) = {
    val seats = getSeats(file)
    fullSeatPlan.filter(s => !seats.exists(p => p._3 == s._3) && seats.exists(p => p._3 == s._3 + 1) && seats.exists(p => p._3 == s._3 - 1))
  }

  println(getSeats("05.txt").map(_._3).max)
  println(getMissing("05.txt"))
}