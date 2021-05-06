package de.htwg.se.riskgame

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class RiskGameSpec extends AnyWordSpec with Matchers {
  "The RiskGame main class" should {
    "accept text input as argument without readline loop, to test it from command line " in {
      RiskGame.main(Array[String]("s"))
    }
  }
}
