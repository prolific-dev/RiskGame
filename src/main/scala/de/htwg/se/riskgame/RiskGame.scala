package de.htwg.se.riskgame

import de.htwg.se.riskgame.aview.Tui
import de.htwg.se.riskgame.model.Battlefield
import de.htwg.se.riskgame.util.PrintMessage.helloMessage

import scala.io.StdIn.readLine

object RiskGame {
  val tui = new Tui
  var battlefield: Battlefield = Battlefield("", Nil)

  def main(args: Array[String]): Unit = {
    var input = ""

    println(helloMessage())

    do {
      input = readLine()
      battlefield = tui.processInputLine(input, battlefield)
      battlefield.printMap()
    } while (input != "q")
  }
}
