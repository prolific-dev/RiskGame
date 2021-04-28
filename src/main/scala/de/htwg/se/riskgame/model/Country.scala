package de.htwg.se.riskgame.model

import de.htwg.se.riskgame.util.Team

import scala.Console._


case class Country(name: String, neighbors: List[String], holder: Team.Value, army: Int) {

  def holderToString: String = holder.toString

  def armyToString: String = army.toString

  override def toString: String = name

  def toColoredString: String = {
    holder.id match {
      case 1 => s"$RESET$BLUE${army.toString}$RESET"
      case 2 => s"$RESET$RED${army.toString}$RESET"
      case 3 => s"$RESET$GREEN${army.toString}$RESET"
      case 4 => s"$RESET$YELLOW${army.toString}$RESET"
    }
  }

}
