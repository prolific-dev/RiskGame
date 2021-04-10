package de.htwg.se.riskgame.model

import org.scalatest.{Matchers, WordSpec}

class CountrySpec extends WordSpec with Matchers {
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
