package de.htwg.se.riskgame.aview

import de.htwg.se.riskgame.RiskGame
import de.htwg.se.riskgame.model.Battlefield

class Tui {

  def processInputLine(input: String, battlefield: Battlefield): Battlefield = {
    input match {
      case "q" => battlefield
      case "i" =>
        println("Battlefield gets initialized. Get ready for the war!")
        RiskGame.init("worldmap")
      case "m" =>
        println("Map: (Still in process)")
        battlefield
      case "c" =>
        for (element <- battlefield.continentList) {
          println(element.toString)
        }
        battlefield
      case _ => battlefield
    }
  }

}
