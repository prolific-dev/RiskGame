package de.htwg.se.riskgame.model

import de.htwg.se.riskgame.util.Team

case class Player(name: String, team: Team.Value) {
  override def toString: String = name
}
