package de.htwg.se.riskgame.model

import de.htwg.se.riskgame.model.Team.Team

case class Player(name: String, teamColor: Team) {
  override def toString: String = name
}
