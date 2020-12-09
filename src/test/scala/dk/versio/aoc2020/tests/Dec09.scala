package dk.versio.aoc2020.tests

import dk.versio.aoc2020.{Common, Dec08, Dec09}
import org.scalatest.flatspec._
import org.scalatest.matchers._

class Dec09 extends AnyFlatSpec with should.Matchers {

  "Dec 09" should "have weak" in {
    val sample = Common.loadNumbers("09-sample.txt")
    Dec09.compute(sample.take(5), sample.drop(5)) shouldBe 127
  }

  "Dec 09" should "find weak" in {
    val sample = Common.loadNumbers("09-sample.txt")
    Dec09.findWeak(sample, 127) shouldBe List(62)
  }


}
