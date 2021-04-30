package de.htwg.se.riskgame.controller

import de.htwg.se.riskgame.model.Battlefield
import de.htwg.se.riskgame.util.{Loader, Observable}

class Controller(var battlefield: Battlefield) extends Observable {

  def setPlayers(players: Int): Unit = {
    battlefield = battlefield.copy(players = players)
    notifyObservers()
  }

  def loadMap(map: String): Unit = {
    battlefield = Loader.loadMap(map, battlefield.players)
    notifyObservers()
  }

  def printMap(): Unit = {
    battlefield.printMap()
    notifyObservers()
  }


}
