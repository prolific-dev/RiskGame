package de.htwg.se.riskgame.model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec


class BattlefieldSpec extends AnyWordSpec with Matchers {
  "A Battlefield" when {
    "new" should {
      val battlefield = Battlefield("Battlefield Name", "Map Name")
      "have a battlefield name" in {
        battlefield.name should be("Battlefield Name")
        battlefield.mapName should be("Map Name")
      }
      "have a nice String representation" in {
        battlefield.toString should be("Battlefield Name")
        battlefield.mapToString should be("Map Name")
      }
    }
  }
}
