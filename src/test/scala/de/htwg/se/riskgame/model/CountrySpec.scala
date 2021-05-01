package de.htwg.se.riskgame.model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.Console._

class CountrySpec extends AnyWordSpec with Matchers {
  "A Country" when {
    "new" should {
      val country = Country("Country Name", Nil, Team(1), 3)
      "have a country name, a neighbor list, a team holder, an army value" in {
        country.name should be("Country Name")
        country.neighbors should be(Nil)
        country.holder should be(Team(1))
        country.army should be(3)
      }
      "have the right type parameter" in {
        country.name.isInstanceOf[String] should be(true)
        country.neighbors.isInstanceOf[List[String]] should be(true)
        country.holder.isInstanceOf[Team.Value] should be(true)
        country.army.isInstanceOf[Int] should be(true)
      }
      "have a nice String representation" in {
        country.nameToString should be("Country Name")
        country.holderToString should be("BLUE")
        country.armyToString should be("3")
        country.toString should be(s"Country Name($RESET${BLUE}3$RESET)")
      }
    }
    "have the right String representation for the right holder" in {
      val countryBlue = Country("Country Name", Nil, Team(1), 3)
      val countryRed = Country("Country Name", Nil, Team(2), 3)
      val countryGreen = Country("Country Name", Nil, Team(3), 3)
      val countryYellow = Country("Country Name", Nil, Team(4), 3)
      countryBlue.toString should be(s"Country Name($RESET${BLUE}3$RESET)")
      countryRed.toString should be(s"Country Name($RESET${RED}3$RESET)")
      countryGreen.toString should be(s"Country Name($RESET${GREEN}3$RESET)")
      countryYellow.toString should be(s"Country Name($RESET${YELLOW}3$RESET)")
    }
  }
}
