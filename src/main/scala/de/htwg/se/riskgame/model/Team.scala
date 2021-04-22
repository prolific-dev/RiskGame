package de.htwg.se.riskgame.model

import de.htwg.se.riskgame.model

object Team extends Enumeration {
  type Team = Value
  val Blue: model.Team.Value = Value(1)
  val Red: model.Team.Value = Value(2)
  val Green: model.Team.Value = Value(3)
  val Yellow: model.Team.Value = Value(4)
}
