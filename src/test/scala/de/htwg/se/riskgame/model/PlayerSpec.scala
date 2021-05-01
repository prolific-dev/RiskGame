package de.htwg.se.riskgame.model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class PlayerSpec extends AnyWordSpec with Matchers {
  "A Player" when {
    "new" should {
      val player = Player("Your name", Team(1))
      "have a name and a team value" in {
        player.name should be("Your name")
        player.team should be(Team(1))
      }
      "have a nice String representation" in {
        player.toString should be("Your name")
      }
    }
  }
}
