package de.htwg.se.riskgame.model



case class Country(name: String, neighbors: List[String], holder: Team.Value, army: Int) {
  override def toString: String = name
}
