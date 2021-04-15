package de.htwg.se.riskgame.model

import org.scalatest.{Matchers, WordSpec}

class PlayerSpec extends WordSpec with Matchers {
  "A Player" when {
    "new" should {
      val player = Player("Your name", "Team Color")
      "have a name and a team color" in {
        player.name should be("Your name")
        player.teamColor should be("Team Color")
      }
      "have a method to get String representation of the team" in {
        player.teamColorToString should be ("Team Color")
      }
      "have a nice String representation" in {
        player.toString should be("Your name")
      }
    }
  }
}
