package dk.versio.aoc2020

object Dec01 extends App {

  def get2020Combinations(file: String, n: Int): Option[Long] = Common
    .loadNumbers(file)
    .combinations(n)
    .find(p => p.sum == 2020)
    .map(_.product)

  println(Dec01.get2020Combinations("01.txt", 2))
  println(Dec01.get2020Combinations("01.txt", 3))
}
