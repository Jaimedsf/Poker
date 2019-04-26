/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

// Fig. 7.11: DeckOfCardsTest.java
// Card shuffling and dealing.

public class DeckOfCardsTest
{
   // execute application
   public static void main(String[] args)
   {
      DeckOfCards myDeckOfCards = new DeckOfCards();
      myDeckOfCards.shuffle();// place Cards in random order
      
      // print all 52 Cards in the order in which they are dealt
      for (int i = 1; i <= 5; i++)
      {
         // deal and display a Card
         System.out.printf("%-19s", myDeckOfCards.dealCard());
         System.out.println();
      }
      boolean seder = myDeckOfCards.Flush();
      int twopar = myDeckOfCards.fullhouse();
      boolean c = myDeckOfCards.straight();
      int x = twopar;    
       switch (x) {
           case 4:
               System.out.printf("Um Full house");
               break;
           case 2:
               System.out.printf("dois pares");
               break;
           default:
               x =  myDeckOfCards.ParTriQua();
               switch(x){
                   case 0: System.out.println("Nao teve cartas iguais");
                   break;
                   case 1: System.out.println("Teve 1 Par");
                   break;
                   case 2: System.out.println("Teve Trinca");
                   break;
                   case 3: System.out.println("Teve Quadra");
                   break;            
               }        break;
       }
      if(seder == true){
          System.out.printf("Um flush");
      }
      if(c==true){
          System.out.println("Full House");
      }
   } 
} // end class DeckOfCardsTest
