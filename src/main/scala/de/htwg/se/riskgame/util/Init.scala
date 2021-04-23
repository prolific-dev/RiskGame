package de.htwg.se.riskgame.util

import de.htwg.se.riskgame.model.{Battlefield, Continent, Country}

import scala.io.Source
import scala.util.Random.nextInt

object Init {
  def init(name: String): Battlefield = {
    val filename = "src/main/scala/de/htwg/se/riskgame/resources/" + name + ".txt"
    val mapSource = Source.fromFile(filename)

    val defaultArmy = 3
    var battlefield = Battlefield(name, Nil)


    for (line <- mapSource.getLines()) {
      if (line.startsWith("+")) {
        battlefield = addCountry(line)

      } else if (line.startsWith("-")) {
        battlefield = addNeighbor(line)

      } else {
        battlefield = addContinent(line)
      }
    }


    def addContinent(continentLine: String): Battlefield = {
      val newContinentList = Continent(continentLine, Nil) :: battlefield.continentList
      battlefield.copy(continentList = newContinentList)
    }

    def addCountry(countryLine: String): Battlefield = {
      val newCountryList = addCountryToList(countryLine.substring(1))
      val newContinent = battlefield.continentList.head.copy(countryList = newCountryList)
      val newContinentList = newContinent :: battlefield.continentList.drop(1)
      battlefield.copy(continentList = newContinentList)

      battlefield
    }

    def addNeighbor(neighborLine: String): Battlefield = {
      val newNeighbors = addNeighborToList(neighborLine.substring(1))
      val oldCountry = battlefield.continentList.head.countryList.head
      val newCountry = oldCountry.copy(neighbors = newNeighbors)
      val oldCountryList = battlefield.continentList.head.countryList
      val newCountryList = newCountry :: oldCountryList.drop(1)
      val newContinent = battlefield.continentList.head.copy(countryList = newCountryList)
      val newContinentList = newContinent :: battlefield.continentList.drop(1)
      battlefield.copy(continentList = newContinentList)
    }

    def addNeighborToList(neighborName: String): List[String] = {
      val oldNeighbors = battlefield.continentList.head.countryList.head.neighbors
      neighborName :: oldNeighbors
    }

    def addCountryToList(countryName: String): List[Country] = {
      val country = Country(countryName, Nil, Team(nextInt(4) + 1), defaultArmy)
      val oldCountryList = battlefield.continentList.head.countryList
      country :: oldCountryList

    }

    battlefield
  }
}
