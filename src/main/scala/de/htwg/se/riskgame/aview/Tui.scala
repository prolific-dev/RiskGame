package de.htwg.se.riskgame.aview

import de.htwg.se.riskgame.aview.Messages.{chooseMapMessage, helloMessage, initMapMessage, inputNotRecognizedMessage}
import de.htwg.se.riskgame.controller.Controller

class Tui(controller: Controller) {


  def processInputLine(input: String): Unit = {
    input match {
      case "q" | "quit" =>
      case "s" | "start" =>
        println(helloMessage())
        println(chooseMapMessage())
      case "init testmap" | "init worldmap" =>
        val map = input.split(" ")(1)
        println(initMapMessage())
        controller.loadMap(map)
      case _ => println(inputNotRecognizedMessage())
    }
  }
}
