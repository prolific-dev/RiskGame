package de.htwg.se.riskgame.model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec


class ContinentSpec extends AnyWordSpec with Matchers {
  "A Continent" when {
    "new" should {
      val continent = Continent("Continent Name", Nil)
      "have a continent name and a country list" in {
        continent.name should be("Continent Name")
        continent.neighborList should be(Nil)
      }
      "have the right type parameter" in {
        continent.name.isInstanceOf[String] should be(true)
        continent.neighborList.isInstanceOf[List[Country]] should be(true)
      }
      "have a nice String representation" in {
        continent.toString should be("Continent Name")
      }
    }
  }

}
