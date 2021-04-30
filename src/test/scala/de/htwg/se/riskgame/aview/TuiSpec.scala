package de.htwg.se.riskgame.aview

import de.htwg.se.riskgame.controller.Controller
import de.htwg.se.riskgame.model.Battlefield
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class TuiSpec extends AnyWordSpec with Matchers {
  "A RiskGame Tui" should {
    val defaultBattlefield = Battlefield("", Nil, 2)
    val controller = new Controller(defaultBattlefield)
    val tui = new Tui(controller)
    "quit" in {
      tui.processInputLine("q")
      controller.battlefield should be(defaultBattlefield)
    }
    "start" in {
      tui.processInputLine("s")
      controller.battlefield should be(defaultBattlefield)
    }
    "initialize a new battlefield" in {
      tui.processInputLine("init testmap")
      controller.battlefield.name should be("testmap")
      controller.battlefield.continentList should not be Nil
    }
    "input does not match options" in {
      val arbitraryString = "asdf"
      val bfNameBefore = controller.battlefield.name
      val bfConListBefore = controller.battlefield.continentList
      tui.processInputLine(arbitraryString)
      controller.battlefield.name should equal(bfNameBefore)
      controller.battlefield.continentList should equal(bfConListBefore)
    }
  }
}
