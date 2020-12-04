package dk.versio.aoc2020.tests

import dk.versio.aoc2020.Dec04
import org.scalatest.flatspec._
import org.scalatest.matchers._

class Dec04 extends AnyFlatSpec with should.Matchers {

  "loader" should "convert-and-repeat" in {
    val p = Dec04.loadPassports("04-sample.txt")
    p
  }

  "Part 01" should "success" in {
    Dec04.getValid("04-sample.txt").length shouldBe 2
  }

  "valid sample" should "have 4" in {
    Dec04.getValidExtended("04-sample-valid.txt").length shouldBe 4

  }
  "invalid sample" should "have 0" in {
    Dec04.getValidExtended("04-sample-invalid.txt").length shouldBe 0
  }

}
