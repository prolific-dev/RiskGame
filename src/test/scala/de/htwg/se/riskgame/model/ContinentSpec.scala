package de.htwg.se.riskgame.model

import org.scalatest.{Matchers, WordSpec}

class ContinentSpec extends WordSpec with Matchers {
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
