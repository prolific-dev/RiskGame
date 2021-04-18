package de.htwg.se.riskgame.model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class CountrySpec extends AnyWordSpec with Matchers {
  "A Country" when {
    "new" should {
      val country = Country("Country Name")
      "have a country name" in {
        country.name should be("Country Name")
      }
      "have a nice String representation" in {
        country.toString should be("Country Name")
      }
    }
  }
}
