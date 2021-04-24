package de.htwg.se.riskgame.model

import de.htwg.se.riskgame.util.Team


case class Country(name: String, neighbors: List[String], holder: Team.Value, army: Int) {
  override def toString: String = name
}
