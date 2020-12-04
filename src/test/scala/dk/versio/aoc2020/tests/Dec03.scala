package dk.versio.aoc2020.tests

import dk.versio.aoc2020.Dec03
import org.scalatest.flatspec._
import org.scalatest.matchers._

class Dec03 extends AnyFlatSpec with should.Matchers {

  "loader" should "convert-and-repeat" in {
    val map = Dec03.getMap("03-sample.txt", 3)
    map
  }

  "Part 01" should "success" in {
    Dec03.countTrees("03-sample.txt", 3) shouldBe 7
  }

  "Part 02" should "success" in {
    Dec03.countAlternatives("03-sample.txt") shouldBe 336
  }

}
