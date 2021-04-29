package de.htwg.se.riskgame.aview

import de.htwg.se.riskgame.model.Battlefield
import de.htwg.se.riskgame.util.Loader.loadMap
import de.htwg.se.riskgame.util.PrintMessage.{chooseMapMessage, initMapMessage, inputNotRecognizedMessage}

class Tui {


  def processInputLine(input: String, battlefield: Battlefield): Battlefield = {
    input match {
      case "q" | "quit" => battlefield
      case "s" | "start" =>
        println(chooseMapMessage())
        battlefield
      case "init testmap" | "init worldmap" =>
        val mapToInit = input.split(" ")(1)
        println(initMapMessage())
        loadMap(mapToInit, battlefield.players)
      case _ =>
        println(inputNotRecognizedMessage())
        battlefield
    }
  }

}
