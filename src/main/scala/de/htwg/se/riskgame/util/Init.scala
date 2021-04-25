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
      val newContinentList = updateContinentList(addCountryToList(countryLine.substring(1)))
      battlefield.copy(continentList = newContinentList)
    }

    // TODO: Check if method might be compatible with updateContinentList()
    def addNeighbor(neighborLine: String): Battlefield = {
      val newCountry = updateCountry(addNeighborToList(neighborLine.substring(1)))
      val oldCountryList = battlefield.continentList.head.countryList
      val newContinentList = updateContinentList(newCountry :: oldCountryList.drop(1))
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

    def updateContinentList(newCountryList: List[Country]): List[Continent] = {
      val newContinent = battlefield.continentList.head.copy(countryList = newCountryList)
      newContinent :: battlefield.continentList.drop(1)
    }

    def updateCountry(newNeighbors: List[String]): Country = {
      val oldCountry = battlefield.continentList.head.countryList.head
      oldCountry.copy(neighbors = newNeighbors)
    }
    battlefield
  }
}
