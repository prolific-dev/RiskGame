package de.htwg.se.riskgame.model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec


class BattlefieldSpec extends AnyWordSpec with Matchers {
  "A Battlefield" when {
    "new" should {
      val battlefield = Battlefield("Battlefield Name", Nil, 2)
      "have a battlefield name and a continent list" in {
        battlefield.name should be("Battlefield Name")
        battlefield.continentList should be(Nil)
        battlefield.players should be(2)
      }
      "have the right type parameter" in {
        battlefield.name.isInstanceOf[String] should be(true)
        battlefield.continentList.isInstanceOf[List[Continent]] should be(true)
        battlefield.players.isInstanceOf[Int] should be(true)
      }
      "have a nice String representation" in {
        battlefield.toString should be("Battlefield Name")
      }
    }
    "initialization and printable matrix" should {
      // Similar to testmap.txt
      val cty1_1 = Country("cty1_1", List("cty1_2"), Team(1), 3)
      val cty1_2 = Country("cty1_2", List("cty1_2", "cty2_2"), Team(1), 3)
      val cty2_1 = Country("cty2_1", List("cty2_2"), Team(2), 3)
      val cty2_2 = Country("cty2_2", List("cty2_1", "cty2_3", "cty1_2"), Team(2), 3)
      val cty2_3 = Country("cty2_3", List("cty2_2"), Team(2), 3)
      val co1 = Continent("co1", List(cty1_1, cty1_2))
      val co2 = Continent("co2", List(cty2_1, cty2_2, cty2_3))
      val battlefield = Battlefield("battlefield", List(co1, co2), 2)

      "initialize a map matrix" in {
        battlefield.maxCountryListSize should be(3)
        battlefield.mapMatrix should be(Array(Array(cty1_1, cty2_1), Array(cty1_2, cty2_2), Array(null, cty2_3)))
      }
      "map as string" in {
        // Add more tests here
        val map = battlefield.mapToString()
        map.isInstanceOf[String] should be(true)
      }
    }
  }
}
