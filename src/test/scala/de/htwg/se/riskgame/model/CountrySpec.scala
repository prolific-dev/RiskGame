package de.htwg.se.riskgame.model

import de.htwg.se.riskgame.util.Team
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.Console.{BLUE, RESET}

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
        country.toString should be("Country Name")
        country.holderToString should be("BLUE")
        country.armyToString should be("3")
        country.toColoredString should be(s"$RESET${BLUE}3$RESET")
      }
    }
  }
}
