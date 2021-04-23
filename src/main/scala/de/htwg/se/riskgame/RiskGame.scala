package de.htwg.se.riskgame

import de.htwg.se.riskgame.model._
import scala.util.Random.nextInt

import scala.io.Source

object RiskGame {
  def main(args: Array[String]): Unit = {
    println(helloWorld())
    init("worldmap")
  }

  def init(name: String): Battlefield = {
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
        val oldCountryList = battlefield.continentList.head.countryList
        val newCountryList = country :: oldCountryList
        val newContinent = battlefield.continentList.head.copy(countryList = newCountryList)
        val newContinentList = newContinent :: battlefield.continentList.drop(1)
        battlefield = battlefield.copy(continentList = newContinentList)

      } else {
        val neighborName = line.substring(1)
        val oldNeighbors = battlefield.continentList.head.countryList.head.neighbors
        val newNeighbors = neighborName :: oldNeighbors
        val oldCountry = battlefield.continentList.head.countryList.head
        val newCountry = oldCountry.copy(neighbors = newNeighbors)
        val oldCountryList = battlefield.continentList.head.countryList
        val newCountryList = newCountry :: oldCountryList.drop(1)
        val newContinent = battlefield.continentList.head.copy(countryList = newCountryList)
        val newContinentList = newContinent :: battlefield.continentList.drop(1)
        battlefield = battlefield.copy(continentList = newContinentList)
      }
    }
    battlefield
  }

  def helloWorld(): String = {
    "Welcome to Risk Game!"
  }

}
