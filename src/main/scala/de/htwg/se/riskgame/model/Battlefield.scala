package de.htwg.se.riskgame.model

case class Battlefield(name: String, continentList: List[Continent], players: Int) {

  override def toString: String = name

  def mapToString(): String = {
    var str = ""
    mapMatrix.foreach {
      row =>
        row.foreach(country =>
          if (country == null) str += "#\t"
          else str += (country.toString + "\t"))
        str += "\n"
    }
    str
  }

  def mapMatrix: Array[Array[Country]] = {
    val matrix = Array.ofDim[Country](maxCountryListSize, continentList.size)

    for (continent <- continentList) {
      for (country <- continent.countryList) {
        matrix(continent.countryList.indexOf(country))(continentList.indexOf(continent)) = country
      }
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
