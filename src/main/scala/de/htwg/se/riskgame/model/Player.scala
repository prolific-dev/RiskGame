package de.htwg.se.riskgame.model

case class Player(name: String, color: String) {
  val team: String = color
  def teamToString: String = color
  override def toString: String = name
}
