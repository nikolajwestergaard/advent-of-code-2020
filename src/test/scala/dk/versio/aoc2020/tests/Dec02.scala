package dk.versio.aoc2020.tests

import dk.versio.aoc2020.Dec02._
import org.scalatest.flatspec._
import org.scalatest.matchers._

class Dec02 extends AnyFlatSpec with should.Matchers {

  "Part 01" should "be 2" in {
    getValidCombination("02-sample.txt", sledRentingStrategy).length shouldBe 2
  }

  "Part 02" should "241861950" in {
    getValidCombination("02-sample.txt", tobogganStrategy).length shouldBe 1
  }

}
