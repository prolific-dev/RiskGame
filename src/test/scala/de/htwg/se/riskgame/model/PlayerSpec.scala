package de.htwg.se.riskgame.model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class PlayerSpec extends AnyWordSpec with Matchers {
  "A Player" when {
    "new" should {
      val player = Player("Your name", Team.Blue)
      "have a name and a team color" in {
        player.name should be("Your name")
        player.teamColor should be(Team.Blue)
      }
      "have a nice String representation" in {
        player.toString should be("Your name")
      }
    }
  }
}
