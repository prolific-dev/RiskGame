package de.htwg.se.riskgame.model

import de.htwg.se.riskgame.util.Team


case class Country(name: String, neighbors: List[String], holder: Team.Value, army: Int) {

  def holderToString: String = holder.toString

  def armyToString: String = army.toString

  override def toString: String = name
}
