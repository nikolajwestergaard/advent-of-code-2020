package dk.versio.aoc2020.tests

import dk.versio.aoc2020.Dec07
import org.scalatest.flatspec._
import org.scalatest.matchers._

class Dec07 extends AnyFlatSpec with should.Matchers {

  "Golden bags" should "have 4 combinations" in {
    val b = Dec07.loadBags("07-sample.txt")
    Dec07.getCombinations(b, ("shiny", "gold")).length shouldBe 4
  }

  "Golden bags" should "contain 126 bags" in {
    val b = Dec07.loadBags("07-sample-02.txt")
    Dec07.countBags(b, ("shiny", "gold")) shouldBe 126
  }

}
