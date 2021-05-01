package de.htwg.se.riskgame

import de.htwg.se.riskgame.aview.Tui
import de.htwg.se.riskgame.controller.Controller
import de.htwg.se.riskgame.model.Battlefield

import scala.io.StdIn.readLine

object RiskGame {
  val defaultBattlefield: Battlefield = Battlefield("", Nil, 0)
  val controller = new Controller(defaultBattlefield)
  val tui = new Tui(controller)
  controller.notifyObservers()

  def main(args: Array[String]): Unit = {
    var input: String = "" // replace later with args(0)

    controller.setPlayers(2)

    do {
      input = readLine()
      tui.processInputLine(input)
      println(controller.battlefield.mapToString())
    } while (input != "q")
  }
}
