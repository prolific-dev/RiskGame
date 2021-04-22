package de.htwg.se.riskgame.model

case class Dice(pips: Int) {
  override def toString: String = pips.toString
}
