package dk.versio.aoc2020.tests

import dk.versio.aoc2020.Dec05._
import org.scalatest.flatspec._
import org.scalatest.matchers._

class Dec05 extends AnyFlatSpec with should.Matchers {

  "valid sample" should "have 3 seats matching" in {
    getBinary("0101", '0', '1') shouldBe 5
    getBinary("FBFBBFF", 'F', 'B') shouldBe 44
    getBinary("RLR", 'L', 'R') shouldBe 5
    getSeat("FBFBBFFRLR") shouldBe (44, 5, 357)
  }

}
