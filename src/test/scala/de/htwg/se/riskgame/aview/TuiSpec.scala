package de.htwg.se.riskgame.aview

import de.htwg.se.riskgame.model.Battlefield
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class TuiSpec extends AnyWordSpec with Matchers {
  "A RiskGame Tui" should {
    val tui = new Tui()
    var battlefield = Battlefield("", Nil, 2)
    "quit" in {
      battlefield = tui.processInputLine("q", battlefield)
      battlefield.name should be("")
      battlefield.continentList should be(Nil)
    }
    "start" in {
      battlefield = tui.processInputLine("s", battlefield)
      battlefield.name should be("")
      battlefield.continentList should be(Nil)
    }
    "initialize a new battlefield" in {
      battlefield = tui.processInputLine("init testmap", battlefield)
      battlefield.name should be("testmap")
      battlefield.continentList should not be Nil
    }
    "input does not match options" in {
      val arbitraryString = "asdf"
      val bfNameBefore = battlefield.name
      val bfConListBefore = battlefield.continentList
      battlefield = tui.processInputLine(arbitraryString, battlefield)
      battlefield.name should equal(bfNameBefore)
      battlefield.continentList should equal(bfConListBefore)
    }
  }
}
