package de.htwg.se.riskgame.aview

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MessagesSpec extends AnyWordSpec with Matchers {
  "A Message object" should {
    "contain several methods for a console print out" in {
      Messages.helloMessage() should be("\nWelcome to Risk Game!\n")
      Messages.choosePlayersMessage() should be("How many players are going to play? (2-4)")
      Messages.chooseMapMessage() should be("Choose a map (type \"init ~map~\"):\n worldmap\n testmap")
      Messages.initMapMessage() should be("Battlefield gets initialized...\nGet ready for the war!")
      Messages.mapNotFoundMessage() should be("Map not found. Choose again.")
      Messages.inputNotRecognizedMessage() should be("Input was not recognized. Try again.")
    }
  }
}
