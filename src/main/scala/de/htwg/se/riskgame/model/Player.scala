package de.htwg.se.riskgame.model

case class Player(name: String, teamColor: String) {
  def teamColorToString: String = teamColor
  override def toString: String = name
}
