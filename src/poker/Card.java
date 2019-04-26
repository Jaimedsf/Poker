/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

// Fig. 7.9: Card.java
// Card class represents a playing card.

public class Card 
{
   private final int face; // face of card ("Ace", "Deuce", ...)
   private final String suit; // suit of card ("Hearts", "Diamonds", ...)

   // two-argument constructor initializes card's face and suit
   public Card(int face, String suit)
   {
      this.face = face;
      this.suit = suit; 
   } 

    public int getFace() {
        return face;
    }

    public String getSuit() {
        return suit;
    }

   // return String representation of Card
   @Override
   public String toString() 
   { 
      return face + " of " + suit;
   } 
} // end class Card
