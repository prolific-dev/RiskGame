package de.htwg.se.riskgame

import de.htwg.se.riskgame.model._
import scala.util.Random.nextInt

import scala.io.Source

object RiskGame {
  def main(args: Array[String]): Unit = {
    println(helloWorld())
    init("worldmap")
  }

  def init(name: String): Unit = {
    val filename = "src/main/scala/de/htwg/se/riskgame/resources/" + name + ".txt"
    val mapSource = Source.fromFile(filename)

    var battlefield = Battlefield(name, Nil)
    val defaultArmy = 3

    for (line <- mapSource.getLines()) {
      if (!(line.startsWith("+") || line.startsWith("-"))) {
        val continentName = line
        val continent = Continent(continentName, Nil)
        val newContinentList = continent :: battlefield.continentList
        battlefield = battlefield.copy(continentList = newContinentList)

      } else if (line.startsWith("+")) {
        val countryName = line.substring(1)
        val country = Country(countryName, Nil, Team(nextInt(4) + 1), defaultArmy)

        val newCountryList = country :: battlefield.continentList.head.countryList

        val newContinent = battlefield.continentList.head.copy(countryList = newCountryList)

        val newContinentList = newContinent :: battlefield.continentList

        battlefield = battlefield.copy(continentList = newContinentList)

      }
    }

    for (e <- battlefield.continentList) {
      println(e.toString)
    }
  }

  def helloWorld(): String = {
    "Welcome to Risk Game!"
  }

}
