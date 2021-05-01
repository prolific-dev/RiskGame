package de.htwg.se.riskgame.model

import de.htwg.se.riskgame.model.Team.Team
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class TeamSpec extends AnyWordSpec with Matchers {
  "A Team object" should {
    val blue = Team(1)
    val red = Team(2)
    val green = Team(3)
    val yellow = Team(4)
    "team should be type of Team" in {
      blue.isInstanceOf[Team] should be(true)
      red.isInstanceOf[Team] should be(true)
      green.isInstanceOf[Team] should be(true)
      yellow.isInstanceOf[Team] should be(true)
    }
    "have an id" in {
      blue.id should be(1)
      red.id should be(2)
      green.id should be(3)
      yellow.id should be(4)
    }
    "have a string value that describes the color" in {
      blue.toString should be("BLUE")
      red.toString should be("RED")
      green.toString should be("GREEN")
      yellow.toString should be("YELLOW")
    }
  }
}
