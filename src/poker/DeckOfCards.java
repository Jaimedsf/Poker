/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

// Fig. 7.10: DeckOfCards.java
// DeckOfCards class represents a deck of playing cards.
import java.security.SecureRandom;

public class DeckOfCards
{
   private final Card[] deck; // array of Card objects
   private int currentCard; // index of next Card to be dealt (0-51)
   private static final int NUMBER_OF_CARDS = 52; // constant # of Cards
   // random number generator
   private static final SecureRandom randomNumbers = new SecureRandom();

   // constructor fills deck of Cards
   public DeckOfCards()
   {
       // transformei em numeros pra ficar mais intuitivo
      int[] faces = {1, 2, 3, 4, 5, 6, 
         7, 8, 9, 10, 11, 12, 13};
      String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

      deck = new Card[NUMBER_OF_CARDS]; // create array of Card objects
      currentCard = 0; // first Card dealt will be deck[0]

      // populate deck with Card objects
      for (int count = 0; count < deck.length; count++) 
         deck[count] = 
            new Card(faces[count % 13], suits[count / 13]);
   } 
   public void euquero(){
       Card temp = deck[1];        
       deck[1] = deck[14];   
       deck[14] = temp; 
       temp = deck[2];        
       deck[2] = deck[15];   
       deck[15] = temp;
       temp = deck[3];        
       deck[3] = deck[16];   
       deck[16] = temp;
   }
   // shuffle deck of Cards with one-pass algorithm
   public void shuffle()
   {
      // next call to method dealCard should start at deck[0] again
      currentCard = 0; 

      // for each Card, pick another random Card (0-51) and swap them
      for (int first = 0; first < deck.length; first++) 
      {
         // select a random number between 0 and 51 
         int second =  randomNumbers.nextInt(NUMBER_OF_CARDS);
         
         // swap current Card with randomly selected Card
         Card temp = deck[first];        
         deck[first] = deck[second];   
         deck[second] = temp;            
      } 
   } 

   // deal one Card
   public Card dealCard()
   {
      // determine whether Cards remain to be dealt
      if (currentCard < deck.length)
         return deck[currentCard++]; // return current Card in array
      else        
         return null; // return null to indicate that all Cards were dealt
   } 
   public boolean Flush(){
       if(deck[0].getSuit().equals(deck[1].getSuit()) &&
          deck[0].getSuit().equals(deck[2].getSuit()) &&
          deck[0].getSuit().equals(deck[3].getSuit()) &&
          deck[0].getSuit().equals(deck[4].getSuit())){
           return true;
       };
       return false;
    }
   public boolean straight(){
       int c = 0;
        for(int i = 0; i < 5; i++){
            for(int f = 0; f < 5; f++){
                if(deck[i].getFace() == (deck[f].getFace())+1){
                    c = c+1;
                }
            }
       }
       return c==4;    
   }
   public int fullhouse(){
      int pp = 0;
   for(int i = 0; i < 5; i++){
        for(int f = i+1; f < 5; f++){
            if(deck[i].getFace() == deck[f].getFace()){
                pp= pp+1;
            }
        }
       }
   return pp;
  }
   
  public int TwoPar(){
      int pp = 0;
   for(int i = 0; i < 5; i++){
        for(int f = i+1; f < 5; f++){
            if(deck[i].getFace() == deck[f].getFace()){
                pp= pp+1;
            }
        }
       }
       return pp;
  }
   public int ParTriQua(){
       int p = 0;
       for(int i = 0; i < 5; i++){
           if(p>=2){
               return p;
           }
        for(int f = i+1; f < 5; f++){
            if(deck[i].getFace() == deck[f].getFace()){
                p = p+1;
            }
        }
       }
     return p;  
    }

   
} // end class DeckOfCards

