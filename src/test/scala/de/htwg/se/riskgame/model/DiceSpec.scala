package de.htwg.se.riskgame.model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class DiceSpec extends AnyWordSpec with Matchers {
  "A Dice" when {
    "new" should {
      val dice = Dice(scala.util.Random.nextInt(6) + 1)
      "have pips between 1 and 6 " in {
        dice.pips should {
          equal(1) or
          equal(2) or
          equal(3) or
          equal(4) or
          equal(5) or
          equal(6)
        }
      }
      "pips are instance of Int" in {
        dice.pips.isInstanceOf[Int] should be(true)
      }
      "have a nice String representation" in {
        dice.toString should {
          equal("1") or
          equal("2") or
          equal("3") or
          equal("4") or
          equal("5") or
          equal("6")
        }
      }
    }
  }
}
