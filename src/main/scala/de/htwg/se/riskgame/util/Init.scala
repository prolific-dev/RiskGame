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

    def addContinent(newContinent: String): Battlefield = {
      val continentToAdd = Continent(newContinent, Nil)
      val newContinentList = updateContinentList(continentToAdd)
      updateBattlefield(newContinentList)
    }

    def addCountry(newCountry: String): Battlefield = {
      val countryToAdd = Country(newCountry.substring(1), Nil, Team(nextInt(4) + 1), defaultArmy)
      val oldContinentList = battlefield.continentList
      val oldContinent = oldContinentList.head
      val newCountryList = updateCountryList(countryToAdd)
      val newContinentList = updateContinentList(oldContinent.copy(countryList = newCountryList))
      updateBattlefield(newContinentList)
    }

    def addNeighbor(newNeighbor: String): Battlefield = {
      val oldContinentList = battlefield.continentList
      val oldContinent = oldContinentList.head
      val oldCountryList = oldContinent.countryList
      val oldCountry = oldCountryList.head
      val newNeighborList = updateNeighborList(newNeighbor)
      val newCountryList = updateCountryList(oldCountry.copy(neighbors = newNeighborList))
      val newContinentList = updateContinentList(oldContinent.copy(countryList = newCountryList))
      updateBattlefield(newContinentList)
    }

    def updateBattlefield(newContinentList: List[Continent]): Battlefield = {
      battlefield.copy(continentList = newContinentList)
    }

    def updateContinentList(newContinent: Continent): List[Continent] = {
      val oldContinentList = battlefield.continentList

      if (oldContinentList.isEmpty) {
        newContinent :: oldContinentList
      } else if (oldContinentList.head.name.equals(newContinent.name)) {
        newContinent :: oldContinentList.drop(1)
      } else {
        newContinent :: oldContinentList.drop(1)
      }
    }

    def updateCountryList(newCountry: Country): List[Country] = {
      val oldContinentList = battlefield.continentList
      val oldContinent = oldContinentList.head
      val oldCountryList = oldContinent.countryList

      if (oldCountryList.isEmpty) {
        newCountry :: oldCountryList
      } else if (oldCountryList.head.name.equals(newCountry.name)) {
        newCountry :: oldCountryList.drop(1)
      } else {
        newCountry :: oldCountryList.drop(1)
      }
    }

    def updateNeighborList(newNeighbor: String): List[String] = {
      val oldContinentList = battlefield.continentList
      val oldContinent = oldContinentList.head
      val oldCountryList = oldContinent.countryList
      val oldCountry = oldCountryList.head
      val oldNeighborsList = oldCountry.neighbors
      val neighborToAdd = newNeighbor.substring(1)
      neighborToAdd :: oldNeighborsList
    }

    battlefield
  }
}
