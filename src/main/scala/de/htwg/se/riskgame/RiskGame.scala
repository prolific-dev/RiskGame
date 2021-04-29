package de.htwg.se.riskgame

import de.htwg.se.riskgame.aview.Tui
import de.htwg.se.riskgame.model.Battlefield
import de.htwg.se.riskgame.util.PrintMessage.{choosePlayersMessage, helloMessage}

import scala.io.StdIn.readLine

object RiskGame {
  val tui = new Tui
  var battlefield: Battlefield = Battlefield("", Nil, 0)

  def main(args: Array[String]): Unit = {
    var input = ""
    var players = 0

    println(helloMessage())
    println
    println(choosePlayersMessage())

    do {
      try {
        players = readLine().toInt
      } catch {
        case _: Throwable => println("Input must be a number of type Integer.")
      }
    } while (players < 2 || players > 4)

    battlefield = battlefield.copy(players = players)

    do {
      input = readLine()
      battlefield = tui.processInputLine(input, battlefield)
      battlefield.printMap()
    } while (input != "q")
  }
}
