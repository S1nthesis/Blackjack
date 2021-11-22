//********************************************************************************************************************************************************
//
//                CARD.java                                                                     Creator: Christopher Vu
//
//
//                Description: This class creates a CARD by way of connecting the rank and suit. 
//
//
//********************************************************************************************************************************************************
public class CARD{
   int cardRank, cardSuit;
   String rank, suit;
   private int cardValue;
   String cardURL;
   
   public CARD(int Rank, int Suit){ 
   // connect the variables to the arguments using "this"
      this.cardRank = Rank;
      this.cardSuit = Suit;
      
 
      if (this.cardRank == 1){ // create an algorithm for calculating the cardValues 
         // for case 1, an ace is worth 14 (rank) and the cardValue would be rank * 10 + suit
         this.cardValue = 14 * 10 + this.cardSuit;
      }   
      else{
        // cardValue would be rank * 10 + suit
        this.cardValue = this.cardRank * 10 + this.cardSuit;
        
     }
     
   }
   
   public String getCardURL() {
      return "Images\\" + getRankAsString()+ getSuitAsString() + ".png";
   }
   
   public int getRank(){
      return this.cardRank;
   }
   
   public int getSuit(){
      return this.cardSuit;
   }
   
   public String getRankAsString(){ //converts rank to a string
      //0 = Ace
      if(this.cardRank == 1){
        this.rank = "A";
      }
      //2 = Two
      else if(this.cardRank == 2){
        this.rank = "2";
         }
      //3 = Three
      else if(this.cardRank == 3){
        this.rank = "3";
         }
      //4 = Four
      else if(this.cardRank == 4){
         this.rank = "4";
         }
      //5 = Five
      else if(this.cardRank == 5){
         this.rank = "5";
         }
      //6 = Six
      else if(this.cardRank == 6){
         this.rank = "6";
         }
      //7 = Seven
      else if(this.cardRank == 7){
         this.rank = "7";
         }
      //8 = Eight
      else if(this.cardRank == 8){
        this.rank = "8";
         }
      //9 = Nine
      else if(this.cardRank == 9){
         this.rank = "9";
         }
      //10 = Ten
      else if(this.cardRank == 10){
         this.rank = "10";
         }
      //11 = Jack
      else if(this.cardRank == 11){
        this.rank = "J";

         }
      //12 = Queen
      else if(this.cardRank == 12){
         this.rank = "Q";
         }
      //13 = King
      else if(this.cardRank == 13){
         this.rank = "K";
 }
      return this.rank;
 }
   public String getSuitAsString(){ //converts suit to a string
      //0 = clubs
      if(this.cardSuit == 1){
         this.suit = "C";
      }
      //1 = diamonds
      else if(this.cardSuit == 2){
         this.suit = "D";
      }
      //2 = hearts
      else if(this.cardSuit == 3){
         this.suit = "H";
      }
      //3 = spades
      else if(this.cardSuit == 4){
         this.suit = "S";
      }
      return this.suit;
   }
   
   public String toString(){
      return getRankAsString()+ getSuitAsString();
   }
}