import java.lang.*;
//********************************************************************************************************************************************************
//
//                DECK.java                                                                     Creator: [your name]
//
//
//                Description: This class creates a DECK of Card objects.  
//
//
//********************************************************************************************************************************************************

public class DECK{

   public static final int NCARDS = 52; //a constant (stays at 52 cards)
   
   private CARD[] Deck;
   private int currentCard;
   private int deckSize;
   
   public DECK(){
      // create a deck that is of size NCARDS
      this.Deck = new CARD[NCARDS];
      
      this.deckSize = 0;
   } 
    
   public void createGameDeck(){
      for(int suit = 1; suit < 5; suit++){
         for(int rank = 1; rank < 14; rank++){
            this.Deck[this.deckSize] = new CARD(rank, suit); // Create an object of class CARD (This will call the constructor)
            this.deckSize++;
          }
       }
      this.currentCard = 0;

   }
   
   public int getDeckSize(){
      return this.deckSize;   
   }
   
   public void swap(int i, int j){
      CARD tmpValue = this.Deck[i];
      this.Deck[i] = this.Deck[j];
      this.Deck[j] = tmpValue;
   }
   
   public void shuffle(){ //shuffles the card into the deck
      //create a unique shuffle method, that rearranges the card objects in a deck
      int i, j, k;

      for ( k = 0; k < NCARDS; k++ ){
          i = (int) ( NCARDS * Math.random() );  // Pick 2 random cards      
          j = (int) ( NCARDS * Math.random() );  // in the deck
          /* ---------------------------------
             Swap these randomly picked cards
             --------------------------------- */
          swap(i, j);// reference to the swap method
      }

      this.currentCard = 0; 
   }
   
   public void Insert(CARD crd){
   
     //create an insert method for inserting card objects into the deck
     
     this.deckSize++; //important because as you insert a card you are increasing the size of the deck
     this.Deck[this.deckSize-1] = crd;
   }
   
   public void delete(int index){
      //create a deletion function that deletes cards by way of an index
      for(int Index = index; Index < this.deckSize-1; Index++){
         this.Deck[Index] = this.Deck[Index+1];
      }
      this.deckSize--; //important because as you delete a card you are decreasing the size of the deck
 }
     
  public CARD getCard(int index){
      return this.Deck[index]; //return a card at a specific index in the deck
  }
  
  public int cardSearch(DECK array, int left, int right, int element){
  // element needs to be in the form of a rank (1,....,14)
       if (right >= left){
         int middle_element = left + (right - left) / 2;
         if (array.getCard(middle_element).getRank() == element)
            return middle_element;
         else{
            if (array.getCard(middle_element).getRank() > element)
               return cardSearch(array, left, middle_element - 1, element);
            else{
               return cardSearch(array, middle_element + 1, right, element);
  }
  }
  }
       return -1;     
}
   public void Swap (int pos1, int pos2){
      CARD temp = this.Deck[pos1];
      this.Deck[pos1] = this.Deck[pos2];
      this.Deck[pos2] = temp;
   }
   
   public void insertionSort(){
      for(int i = 0; i< this.deckSize; i++){
         int numSpot = i;
         CARD num = this.Deck[numSpot]; 
         while (numSpot !=0 && this.Deck[numSpot -1].getRank() > num.getRank()){
               Swap(numSpot, numSpot-1);
               numSpot = numSpot - 1;
            }
         }
      }
  
  public int cardsValue() {
      int totalValue = 0;
      int aces = 0;
      
      for(int i = 0; i < this.deckSize; i++) {
         if(Deck[i].getRank() == 1) {
            aces++;
         } else if(Deck[i].getRank() >= 10) {
            totalValue+= 10;
         }
         else {
            totalValue += Deck[i].getRank();
         }
      }
      
      for(int i = 0; i<aces; i++) {
         if(totalValue > 10) {
            totalValue += 1;
         }
         else {
            totalValue +=11;
         }
      }
      
      return totalValue;
  }
  
  public void draw(DECK fullDeck) {
      Insert(fullDeck.getCard(0));
      fullDeck.delete(0);
  }
  
  public void moveAllToDeck(DECK moveTo) {
      //System.out.println(moveTo.toString());
      //System.out.println(toString());
      int thisDeckSize = getDeckSize();
      for(int i = 0; i < thisDeckSize; i++) {
         moveTo.Insert(getCard(i));
      }
      
      for(int i = 0; i < thisDeckSize; i++) {
         delete(0);
      }
      //System.out.println(moveTo.toString());
      //System.out.println(toString());
  }
  
  public String getMessage() {
      String s = "";
   	int k;
    
   	k = 0;
   	for ( int i = 1; i < 5; i++ ){
   	    for ( int j = 1; j < 14; j++)
            if(this.Deck[k] != null)
   		   s += (this.Deck[k++] + " ");
            else
            j = 14;
   	 }
   	 return ( s );
      
  }
  
  public String toString(){
      String s = "";
   	int k;
    
   	k = 0;
   	for ( int i = 1; i < 5; i++ ){
   	    for ( int j = 1; j < 14; j++)
            if(this.Deck[k] != null)
   		   s += (this.Deck[k++] + " ");
            else
            j = 14;
   	 }
   	 return ( s );
      }
      
  }