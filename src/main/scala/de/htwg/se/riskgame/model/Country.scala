package de.htwg.se.riskgame.model

import de.htwg.se.riskgame.model.Team.Team


case class Country(name: String, neighbors: List[String], holder: Team, army: Int) {
  override def toString: String = name
}
