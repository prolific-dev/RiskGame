package de.htwg.se.riskgame

import de.htwg.se.riskgame.aview.Tui
import de.htwg.se.riskgame.controller.Controller
import de.htwg.se.riskgame.model.Battlefield
import de.htwg.se.riskgame.util.PrintMessage.{choosePlayersMessage, helloMessage}

import scala.io.StdIn.readLine

object RiskGame {
  val defaultBattlefield: Battlefield = Battlefield("", Nil, 0)
  val controller = new Controller(defaultBattlefield)
  val tui = new Tui(controller)
  controller.notifyObservers()

  def main(args: Array[String]): Unit = {
    var input = ""
    var players = 0

    println(helloMessage())
    println(choosePlayersMessage())

    players = readLine(choosePlayersMessage()).toInt

    controller.setPlayers(players)

    do {
      input = readLine()
      tui.processInputLine(input)
      tui.printMap(controller.battlefield.mapToString())
    } while (input != "q")
  }
}
