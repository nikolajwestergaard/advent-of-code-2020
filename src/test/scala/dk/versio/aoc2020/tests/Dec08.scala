package dk.versio.aoc2020.tests

import dk.versio.aoc2020.Dec08
import org.scalatest.flatspec._
import org.scalatest.matchers._

class Dec08 extends AnyFlatSpec with should.Matchers {

  "loader" should "give string int pairs" in {
    Dec08.load("08-sample.txt").head shouldBe ("nop", 0)
    Dec08.load("08-sample.txt").last shouldBe ("acc", 6)
  }

  "program" should "acc 5" in {
    Dec08.compute(Dec08.load("08-sample.txt")) shouldBe Right(5)
  }

}
