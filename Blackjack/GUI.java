import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI implements ActionListener{
   JFrame frame;
   ImageIcon image1;
   ImageIcon image2;
   JButton hitButton = new JButton("Hit");
   JButton standButton = new JButton("Stand");
   JButton playButton = new JButton("Play");
   Color tableColor;
   Color hitButtonColor;
   double balance;
   double playerBet;
   boolean roundEnded;
   DECK playingDeck;
   DECK playerDeck;
   DECK dealerDeck;
   //String message;
   String dealerDeckValueMessage;
   String playerDeckValueMessage;
   String dealerDeckDisplay;
   String balanceMessage;
   String resultMessage;
   JLabel result = new JLabel("");
   JLabel deckOfPlayer = new JLabel("Your hand: ");
   JLabel balanceCounter = new JLabel("Balance: ");
   JLabel deckOfDealer = new JLabel("Dealer's Cards: ");
   JLabel playerDeckValue = new JLabel("Your hand is valued at: ");
   JLabel dealerDeckValue = new JLabel("Dealer's hand is valued at: ");
   JLabel [] labelCardsOfPlayer = new JLabel[9];
   JLabel [] labelCardsOfDealer = new JLabel[9];
   public GUI() {
   
      //playingDeck = new DECK();
      //playingDeck.createGameDeck();
      //playingDeck.shuffle();
      //playerDeck = new DECK();
      //dealerDeck = new DECK();
   
      tableColor = new Color(39,119,20);
      Color hitButtonColor = new Color(204,204,0);
   
      deckOfPlayer.setBounds(50,200,200,50);
      result.setBounds(400,250,600,50);
      result.setForeground(Color.red);
      result.setFont(new Font("Impact", Font.BOLD, 30));
      dealerDeckValue.setBounds(0,-5,600,40);
      dealerDeckValue.setFont(new Font("Times New Roman", Font.BOLD, 30));
      playerDeckValue.setBounds(0,180,400,200);
      playerDeckValue.setFont(new Font("Times New Roman", Font.BOLD, 30));
      deckOfDealer.setBounds(300,200,200,50);
      balanceCounter.setBounds(750, 450, 200, 50);
      balanceCounter.setFont(new Font("Times New Roman", Font.BOLD, 30));
      //JButton hitButton = new JButton("Hit");
      hitButton.setBackground(hitButtonColor);
      hitButton.setBounds(450, 450, 100, 60);
      hitButton.setFocusable(false);
      hitButton.setEnabled(false);
      hitButton.addActionListener(this);
      hitButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
      
      //JButton standButton = new JButton("Stand");
      standButton.setBackground(hitButtonColor);
      standButton.setBounds(600, 450, 100, 60);
      standButton.setFocusable(false);
      standButton.setEnabled(false);
      standButton.addActionListener(this);
      standButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
      
      //JButton playButton = new JButton("Play");
      playButton.setBackground(hitButtonColor);
      playButton.setBounds(300, 450, 100, 60);
      playButton.setFocusable(false);
      playButton.addActionListener(this);
      playButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
      balance = 100;
      
      frame = new JFrame("BlackJack");
      frame.setSize(new Dimension(1000,600));
      frame.setResizable(false);
      frame.setLayout(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null);
      frame.add(result);
     // frame.add(deckOfPlayer);
      frame.add(dealerDeckValue);
      frame.add(playerDeckValue);
      //frame.add(deckOfDealer);
      frame.add(balanceCounter);
      frame.add(hitButton);
      frame.add(standButton);
      frame.add(playButton);
      for(int i = 0; i < labelCardsOfPlayer.length; i++) {
         labelCardsOfPlayer[i] = new JLabel();
         labelCardsOfPlayer[i].setBounds(0 + 100*i,300,100,150);
         frame.add(labelCardsOfPlayer[i]);
         labelCardsOfPlayer[i].setVisible(false);
      }
      for(int i = 0; i < labelCardsOfDealer.length; i++) {
         labelCardsOfDealer[i] = new JLabel();
         labelCardsOfDealer[i].setBounds(0 + 100*i,30,100,150);
         frame.add(labelCardsOfDealer[i]);
         labelCardsOfDealer[i].setVisible(false);
      }
      frame.getContentPane().setBackground(tableColor);
      deckOfPlayer.setVisible(true);
      frame.setVisible(true);
   }
   
   public void actionPerformed(ActionEvent e) {
      if(((JButton)e.getSource()).getText().equals("Play")) {
         playingDeck = new DECK();
         playingDeck.createGameDeck();
         playingDeck.shuffle();
         playerDeck = new DECK();
         dealerDeck = new DECK();
         JButton source = (JButton) e.getSource();
         source.setEnabled(false);
         hitButton.setEnabled(true);
         standButton.setEnabled(true);
      //while(balance > 0) {
         System.out.println("Your bet is $20");
         playerBet = 20;
         
         roundEnded = false;
         
         playerDeck.draw(playingDeck);
         playerDeck.draw(playingDeck);
         
         
         dealerDeck.draw(playingDeck);
         dealerDeck.draw(playingDeck);
         
         for(int i = 2; i < labelCardsOfPlayer.length; i++) {
            labelCardsOfPlayer[i].setVisible(false);
         }
      
         for(int i = 2; i < labelCardsOfDealer.length; i++) {
            labelCardsOfDealer[i].setVisible(false);
         }
         
         for(int i = 0; i < playerDeck.getDeckSize(); i++) {
            ImageIcon image = new ImageIcon(playerDeck.getCard(i).getCardURL());
            Image temp = image.getImage().getScaledInstance(100,150, Image.SCALE_SMOOTH);
            ImageIcon p = new ImageIcon(temp);
            labelCardsOfPlayer[i].setIcon(p);
            labelCardsOfPlayer[i].setVisible(true);
         }
         
         for(int i = 0; i < 2; i++) {
            if(i == 0) {
               ImageIcon image = new ImageIcon(dealerDeck.getCard(0).getCardURL());
               Image temp = image.getImage().getScaledInstance(100,150, Image.SCALE_SMOOTH);
               ImageIcon currentCard = new ImageIcon(temp);
               labelCardsOfDealer[0].setIcon(currentCard);
               labelCardsOfDealer[0].setVisible(true);
            }
            
            if(i == 1) {  
               ImageIcon p = new ImageIcon("blue_back.png");
               Image temp2 = p.getImage().getScaledInstance(100,150, Image.SCALE_SMOOTH);
               ImageIcon newCard = new ImageIcon(temp2);
               labelCardsOfDealer[1].setIcon(newCard);
               labelCardsOfDealer[1].setVisible(true);
            }
         }
         
         //message = "Your hand: " + playerDeck.getMessage();
         //deckOfPlayer.setText(message);
         System.out.println(playerDeck.getCard(0).getCardURL());
         balanceMessage = "Balance: $" + balance;
         balanceCounter.setText(balanceMessage);
         
         playerDeckValueMessage = "Your hand is valued at: " + playerDeck.cardsValue();
         playerDeckValue.setText(playerDeckValueMessage);
         
         dealerDeckValueMessage = "Dealer's hand is valued at: [Hidden]";
         dealerDeckValue.setText(dealerDeckValueMessage);
         resultMessage = "";
         result.setText(resultMessage);
         
            //System.out.println("Your deck is valued at: " + playerDeck.cardsValue());
            
            //Displaying the dealer's hand
            //System.out.println("Dealer Hand: " + dealerDeck.getCard(0).toString() + " and [Hidden]");
         dealerDeckDisplay = "Dealer's Cards: " + dealerDeck.getCard(0).toString() + " and [Hidden]";
         deckOfDealer.setText(dealerDeckDisplay);
            
        // while(!buttonPress) {
            
            //System.out.println("Would you like to (1) Hit or (2) Stand?");
            //int response = scan.nextInt();
      }    
        //If Hit
      if(((JButton)e.getSource()).getText().equals("Hit")) {
         playerDeck.draw(playingDeck);
               //System.out.println("You draw a: " + playerDeck.getCard(playerDeck.getDeckSize()-1).toString());
         playerDeckValueMessage = "Your hand is valued at: " + playerDeck.cardsValue();
         playerDeckValue.setText(playerDeckValueMessage);
               /*
               message = "Your hand: ";
               message += playerDeck.getMessage();
               deckOfPlayer.setText(message);
               */
         for(int i = 0; i < playerDeck.getDeckSize(); i++) {
            ImageIcon image = new ImageIcon(playerDeck.getCard(i).getCardURL());
            Image temp = image.getImage().getScaledInstance(100,150, Image.SCALE_SMOOTH);
            ImageIcon p = new ImageIcon(temp);
            labelCardsOfPlayer[i].setIcon(p);
            labelCardsOfPlayer[i].setVisible(true);
         }
               //Player busts if the value of theirs cards > 21
         if(playerDeck.cardsValue() > 21) {
            resultMessage = "Bust. Currently valued at: " + playerDeck.cardsValue();
            result.setText(resultMessage);
                  //System.out.println("Bust. Currently valued at: " + playerDeck.cardsValue() + "\n");
            balance -= playerBet;
            roundEnded = true;
                  //break;   
         }
         if(roundEnded) {
            playerDeck.moveAllToDeck(playingDeck);
            dealerDeck.moveAllToDeck(playingDeck);
            JButton source = (JButton) e.getSource();
            source.setEnabled(false);
            standButton.setEnabled(false);
            playButton.setEnabled(true);
            balanceMessage = "Balance: $" + balance;
            balanceCounter.setText(balanceMessage);
            //System.out.println("End of round!");
         }
         if(balance <= 0) {
            resultMessage = "Game over! Out of balance.";
            result.setText(resultMessage);
            hitButton.setEnabled(false);
            standButton.setEnabled(false);
            playButton.setEnabled(false);
            //System.out.println("Game over! Out of balance.");
         }
      }
            
      if(((JButton)e.getSource()).getText().equals("Stand")) {
          //  buttonPress = true;
                     //Show the Player the Dealer's Cards
         for(int i = 0; i < dealerDeck.getDeckSize(); i++) {
            ImageIcon image = new ImageIcon(dealerDeck.getCard(i).getCardURL());
            Image temp = image.getImage().getScaledInstance(100,150, Image.SCALE_SMOOTH);
            ImageIcon p = new ImageIcon(temp);
            labelCardsOfDealer[i].setIcon(p);
            labelCardsOfDealer[i].setVisible(true);
         }
         dealerDeckDisplay = "Dealer's Cards: " + dealerDeck.toString();
         deckOfDealer.setText(dealerDeckDisplay);
         //System.out.println("Dealer's Cards: " + dealerDeck.toString());
         //Determine if the dealer has more points than the player.
         if(!roundEnded && (dealerDeck.cardsValue() > playerDeck.cardsValue())) {
            resultMessage = "Dealer Wins!";
            result.setText(resultMessage);
            //System.out.println("Dealer wins!");
            balance -= playerBet;
            roundEnded = true;
         }
         //Determines if dealer stands or hits (draw at 16, stand at 17)
         while(!roundEnded && (dealerDeck.cardsValue() < 17)) {
            dealerDeck.draw(playingDeck);
            for(int i = 0; i < dealerDeck.getDeckSize(); i++) {
               ImageIcon image = new ImageIcon(dealerDeck.getCard(i).getCardURL());
               Image temp = image.getImage().getScaledInstance(100,150, Image.SCALE_SMOOTH);
               ImageIcon p = new ImageIcon(temp);
               labelCardsOfDealer[i].setIcon(p);
               labelCardsOfDealer[i].setVisible(true);
            }
            dealerDeckDisplay = "Dealer's Cards: " + dealerDeck.toString();
            deckOfDealer.setText(dealerDeckDisplay);
         }
         //Show dealer's value
         //System.out.println("Dealer's hand is valued at " + dealerDeck.cardsValue());
         dealerDeckValueMessage = "Dealer's hand is valued at: " + dealerDeck.cardsValue();
         dealerDeckValue.setText(dealerDeckValueMessage);
         //Has dealer busted?
         if(!roundEnded && (dealerDeck.cardsValue() > 21)) {
            resultMessage = "The dealer has busted! You win!";
            result.setText(resultMessage);
            //System.out.println("The dealer has busted! You win!");
            balance += playerBet;
            roundEnded = true;
         }
         //Is it a tie?
         if(!roundEnded && (playerDeck.cardsValue() == dealerDeck.cardsValue()) ) {
            resultMessage = "Push. It was a tie";
            result.setText(resultMessage);
            //System.out.println("Push. It was a tie");
            roundEnded = true;
         }
         
         if(!roundEnded && (playerDeck.cardsValue() > dealerDeck.cardsValue()) ) {
            resultMessage = "You win this round!";
            result.setText(resultMessage);
            //System.out.println("You win this round!");
            balance += playerBet;
            roundEnded = true;
         } else if(!roundEnded) {
            resultMessage = "Dealer wins!";
            result.setText(resultMessage);
            //System.out.println("You lose the round.");
            balance -= playerBet;
            roundEnded = true;
         }
         
         playerDeck.moveAllToDeck(playingDeck);
         dealerDeck.moveAllToDeck(playingDeck);
         //System.out.println("Player deckend: " + playerDeck.toString());
         //System.out.println("CPU deckend: " + dealerDeck.toString());
         if(roundEnded) {
            //System.out.println("End of round!");
            standButton.setEnabled(false);
            hitButton.setEnabled(false);
            playButton.setEnabled(true);
            balanceMessage = "Balance: $" + balance;
            balanceCounter.setText(balanceMessage);
         }
         if(balance <= 0) {
            resultMessage = "Game over! Out of balance.";
            result.setText(resultMessage);
            hitButton.setEnabled(false);
            standButton.setEnabled(false);
            playButton.setEnabled(false);
            //System.out.println("Game over! Out of balance.");
         }
               //break;
      } 
         
   
        // }
        // }  
      //}
   }

}