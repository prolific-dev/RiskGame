package de.htwg.se.riskgame.model

case class Player(name: String, team: Team.Value) {
  override def toString: String = name
}
