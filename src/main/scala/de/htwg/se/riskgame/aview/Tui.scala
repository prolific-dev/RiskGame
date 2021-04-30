package de.htwg.se.riskgame.aview

import de.htwg.se.riskgame.controller.Controller
import de.htwg.se.riskgame.util.PrintMessage.{chooseMapMessage, initMapMessage, inputNotRecognizedMessage}

class Tui(controller: Controller) {


  def processInputLine(input: String): Unit = {
    input match {
      case "q" | "quit" =>
      case "s" | "start" => println(chooseMapMessage())
      case "init testmap" | "init worldmap" =>
        val mapToInit = input.split(" ")(1)
        println(initMapMessage())
        controller.loadMap(mapToInit)
      case _ => println(inputNotRecognizedMessage())
    }
  }
}
