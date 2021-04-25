package de.htwg.se.riskgame.aview

import de.htwg.se.riskgame.model.Battlefield
import de.htwg.se.riskgame.util.Init.init
import de.htwg.se.riskgame.util.PrintMessage.{chooseMapMessage, initMapMessage, mapNotFoundMessage}

import scala.io.StdIn.readLine

class Tui {

  def processInputLine(input: String, battlefield: Battlefield): Battlefield = {
    input match {
      case "q" => battlefield
      case "i" =>
        var mapToInit = ""
        println(chooseMapMessage())
        while (mapToInit == "") {
          mapToInit = readLine()
          mapToInit match {
            case "worldmap" =>
              println(initMapMessage())
              init(mapToInit)
            case "testmap" =>
              println(initMapMessage())
              init(mapToInit)
            case _ =>
              println(mapNotFoundMessage())
              mapToInit = ""
          }
        }
        battlefield
    }
  }

}
