package de.htwg.se.riskgame.model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec


class ContinentSpec extends AnyWordSpec with Matchers {
  "A Continent" when {
    "new" should {
      val continent = Continent("Continent Name")
      "have a continent name" in {
        continent.name should be("Continent Name")
      }
      "have a nice String representation" in {
        continent.toString should be("Continent Name")
      }
    }
  }

}
