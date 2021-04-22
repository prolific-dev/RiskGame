package de.htwg.se.riskgame.model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec


class BattlefieldSpec extends AnyWordSpec with Matchers {
  "A Battlefield" when {
    "new" should {
      val battlefield = Battlefield("Battlefield Name", Nil)
      "have a battlefield name and a continent list" in {
        battlefield.name should be("Battlefield Name")
        battlefield.continentList should be(Nil)
      }
      "have the right type parameter" in {
        battlefield.name.isInstanceOf[String] should be(true)
        battlefield.continentList.isInstanceOf[List[Continent]] should be(true)
      }
      "have a nice String representation" in {
        battlefield.toString should be("Battlefield Name")
      }
    }
  }
}
