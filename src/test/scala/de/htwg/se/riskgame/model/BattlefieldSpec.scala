package de.htwg.se.riskgame.model

import org.scalatest.{Matchers, WordSpec}

class BattlefieldSpec extends WordSpec with Matchers {
  "A Battlefield" when {
    "new" should {
      val battlefield = Battlefield("Battlefield Name")
      "have a battlefield name" in {
        battlefield.name should be("Battlefield Name")
      }
      "have a nice String representation" in {
        battlefield.toString should be("Battlefield Name")
      }
    }
  }
}
