package de.htwg.se.riskgame.controller

import de.htwg.se.riskgame.model.Battlefield
import de.htwg.se.riskgame.util.Observable

class Controller(var battlefield: Battlefield) extends Observable {
  val loader = new Loader

  def setPlayers(players: Int): Unit = {
    battlefield = battlefield.copy(players = players)
    notifyObservers()
  }

  def loadMap(map: String): Unit = {
    battlefield = loader.loadMap(map, battlefield.players)
    notifyObservers()
  }


}
