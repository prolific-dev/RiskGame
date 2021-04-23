package de.htwg.se.riskgame.model

case class Continent(name: String, countryList: List[Country]) {
  override def toString: String = name
}
