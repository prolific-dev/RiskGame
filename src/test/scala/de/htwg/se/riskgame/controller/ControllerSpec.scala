package de.htwg.se.riskgame.controller

import de.htwg.se.riskgame.model.Battlefield
import de.htwg.se.riskgame.util.Observer
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ControllerSpec extends AnyWordSpec with Matchers {
  "A Controller" when {
    "observed by an Observer" should {
      val defaultBattlefield = Battlefield("", Nil, 2)
      val controller = new Controller(defaultBattlefield)
      val observer = new Observer {
        var updated: Boolean = false

        def isUpdated: Boolean = updated

        override def update(): Unit = updated = true
      }
      controller.add(observer)
      "notify its Observer after set the player amount" in {
        controller.setPlayers(4)
        observer.updated should be(true)
        controller.battlefield.players should be(4)
      }
      "notify its Observer after map load" in {
        controller.loadMap("testmap")
        observer.updated should be(true)
        controller.battlefield.name should be("testmap")
        controller.battlefield.continentList should not be Nil
      }
    }
  }
}
