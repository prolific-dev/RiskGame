package de.htwg.se.riskgame.aview

import de.htwg.se.riskgame.model.Battlefield
import de.htwg.se.riskgame.util.Init.init
import de.htwg.se.riskgame.util.PrintMessage.{initMapMessage, inputNotRecognizedMessage}

class Tui {


  def processInputLine(input: String, battlefield: Battlefield): Battlefield = {
    input match {
      case "q" => battlefield
      case "i testmap" =>
        val mapToInit = input.split(" ")(1)
        println(initMapMessage())
        init(mapToInit)
      case _ =>
        println(inputNotRecognizedMessage())
        battlefield
    }
  }

}
