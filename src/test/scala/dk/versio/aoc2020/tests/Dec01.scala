package dk.versio.aoc2020.tests

import dk.versio.aoc2020.Dec01
import org.scalatest.flatspec._
import org.scalatest.matchers._

class Dec01 extends AnyFlatSpec with should.Matchers {

  "Part 01" should "be 514579" in {
    Dec01.get2020Combinations("01-sample.txt", 2) shouldBe Some(514579)
  }

  "Part 02" should "241861950" in {
    Dec01.get2020Combinations("01-sample.txt", 3) shouldBe Some(241861950)
  }

}
