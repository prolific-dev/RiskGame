package de.htwg.se.riskgame.model

import scala.Console._


case class Country(name: String, neighbors: List[String], holder: Team.Value, army: Int) {

  def holderToString: String = holder.toString

  def armyToString: String = army.toString

  override def toString: String = {
    holder.id match {
      case 1 => s"$nameToString($RESET$BLUE$armyToString$RESET)"
      case 2 => s"$nameToString($RESET$RED$armyToString$RESET)"
      case 3 => s"$nameToString($RESET$GREEN$armyToString$RESET)"
      case 4 => s"$nameToString($RESET$YELLOW$armyToString$RESET)"
    }
  }

  def nameToString: String = name

}
