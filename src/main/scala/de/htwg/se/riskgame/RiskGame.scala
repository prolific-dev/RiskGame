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

    do {
      try {
        players = readLine().toInt
      } catch {
        case _: Throwable => println("Input must be a number of type Integer.")
      }
    } while (players < 2 || players > 4)

    controller.setPlayers(players)

    do {
      input = readLine()
      tui.processInputLine(input)
      controller.printMap()
    } while (input != "q")
  }
}
