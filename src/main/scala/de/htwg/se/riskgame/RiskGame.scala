package de.htwg.se.riskgame

import de.htwg.se.riskgame.model._
import de.htwg.se.riskgame.util.Init.init

object RiskGame {
  def main(args: Array[String]): Unit = {
    println(helloWorld())
    val b = init("worldmap")

    for (x <- b.continentList) {
      println(x.toString)
    }
  }

  def helloWorld(): String = {
    "Welcome to Risk Game!"
  }

}
