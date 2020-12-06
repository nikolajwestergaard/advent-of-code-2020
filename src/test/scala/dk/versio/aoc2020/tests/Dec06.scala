package dk.versio.aoc2020.tests

import dk.versio.aoc2020.Dec06
import org.scalatest.flatspec._
import org.scalatest.matchers._

class Dec06 extends AnyFlatSpec with should.Matchers {

  "valid sample" should "sum of 11" in {
    Dec06.loadCustomAnswers("06-sample.txt").map(_.length).sum shouldBe 11
  }

  "valid sample" should "sum of 6" in {
    Dec06.loadCustomAnswersCommon("06-sample.txt").map(_.length).sum shouldBe 6
  }

}
