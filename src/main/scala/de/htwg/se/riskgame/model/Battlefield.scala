package de.htwg.se.riskgame.model

case class Battlefield(name: String, mapName: String) {
  def mapToString: String = mapName
  override def toString: String = name
}
