package de.htwg.se.riskgame.util

object PrintMessage {
  def helloMessage(): String = {
    "Welcome to Risk Game!"
  }

  def chooseMapMessage(): String = {
    "Choose a map:\n worldmap\n testmap"
  }

  def initMapMessage(): String = {
    "Battlefield gets initialized...\nGet ready for the war!"
  }

  def mapNotFoundMessage(): String = {
    "Map not found. Choose again."
  }

  def inputNotRecognizedMessage(): String = {
    "Input was not recognized. Try again."
  }
}
