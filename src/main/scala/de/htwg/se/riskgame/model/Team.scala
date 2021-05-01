package de.htwg.se.riskgame.model

object Team extends Enumeration {
  type Team = Value

  private val BLUE = Value(1, "BLUE")
  private val RED = Value(2, "RED")
  private val GREEN = Value(3, "GREEN")
  private val YELLOW = Value(4, "YELLOW")
}
