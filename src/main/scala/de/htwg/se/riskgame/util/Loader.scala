package de.htwg.se.riskgame.util

import de.htwg.se.riskgame.model.{Battlefield, Continent, Country}

import scala.io.Source
import scala.util.Random.nextInt

object Loader {
  def loadMap(name: String): Battlefield = {
    val filename = "src/main/scala/de/htwg/se/riskgame/resources/" + name + ".txt"
    val mapSource = Source.fromFile(filename)
    val defaultPlayer = 2
    val defaultArmy = 3
    var battlefield = Battlefield(name, Nil)


    for (line <- mapSource.getLines()) {
      line.head match {
        case '+' => battlefield = addCountry(line)
        case '-' => battlefield = addNeighbor(line)
        case _ => battlefield = addContinent(line)
      }
    }

    def addContinent(newContinent: String): Battlefield = {
      val continentToAdd = Continent(newContinent, Nil)
      val newContinentList = updateContinentList(continentToAdd)
      updateBattlefield(newContinentList)
    }

    def addCountry(newCountry: String): Battlefield = {
      val countryToAdd = Country(newCountry.substring(1), Nil, Team(nextInt(defaultPlayer) + 1), defaultArmy)
      val newCountryList = updateCountryList(countryToAdd)
      val newContinentList = updateContinentList(headContinent().copy(countryList = newCountryList))
      updateBattlefield(newContinentList)
    }

    def addNeighbor(newNeighbor: String): Battlefield = {
      val newNeighborList = updateNeighborList(newNeighbor)
      val newCountryList = updateCountryList(headCountry().copy(neighbors = newNeighborList))
      val newContinentList = updateContinentList(headContinent().copy(countryList = newCountryList))
      updateBattlefield(newContinentList)
    }

    def updateBattlefield(newContinentList: List[Continent]): Battlefield = {
      battlefield.copy(continentList = newContinentList)
    }

    def updateContinentList(newContinent: Continent): List[Continent] = {
      if (oldContinentList().isEmpty || !headContinent().name.equals(newContinent.name)) {
        newContinent :: oldContinentList()
      } else {
        newContinent :: oldContinentList().drop(1)
      }
    }

    def updateCountryList(newCountry: Country): List[Country] = {
      if (oldCountryList().isEmpty || !headCountry().name.equals(newCountry.name)) {
        newCountry :: oldCountryList()
      } else {
        newCountry :: oldCountryList().drop(1)
      }
    }

    def updateNeighborList(newNeighbor: String): List[String] = {
      val neighborToAdd = newNeighbor.substring(1)
      neighborToAdd :: oldNeighborList()
    }

    def oldContinentList(): List[Continent] = battlefield.continentList

    def headContinent(): Continent = oldContinentList().head

    def oldCountryList(): List[Country] = headContinent().countryList

    def headCountry(): Country = oldCountryList().head

    def oldNeighborList(): List[String] = headCountry().neighbors

    battlefield
  }
}
