package de.htwg.se.riskgame.model

case class Battlefield(name: String, continentList: List[Continent]) {

  override def toString: String = name

  def printMap(): Unit = {
    mapMatrix.foreach {
      row =>
        row.foreach(country =>
          if (country == null) print("#\t")
          else print(country.toString + "(" + country.toColoredString + ")\t"))
        println()
    }.toString
  }

  def mapMatrix: Array[Array[Country]] = {
    val matrix = Array.ofDim[Country](maxCountryListSize, continentList.size)

    var continentCounter = 0
    for (continent <- continentList) {
      var countryCounter = 0
      for (country <- continent.countryList) {
        matrix(countryCounter)(continentCounter) = country
        countryCounter += 1
      }
      continentCounter += 1
    }
    matrix
  }

  def maxCountryListSize: Int = {
    var max = 0
    if (continentList.nonEmpty) {
      for (continent <- continentList) {
        if (continent.countryList.size > max) {
          max = continent.countryList.size
        }
      }
    }
    max
  }
}
