package de.htwg.se.riskgame.model

case class Continent(name: String, neighborList: List[Country]) {
  override def toString: String = name
}
