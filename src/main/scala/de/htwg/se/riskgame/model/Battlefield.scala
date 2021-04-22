package de.htwg.se.riskgame.model

case class Battlefield(name: String, continentList: List[Continent]) {
  override def toString: String = name
}
