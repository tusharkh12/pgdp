package pgdp.casino;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Casino {

    public static void penguBlackJack() {

        // Here is a card deck for your games :)
        // Remember for testing you can use seeds:
        CardDeck deck = CardDeck.getDeck(420);
        //CardDeck deck = CardDeck.getDeck();
        int tokens = 1000;
        System.out.println("Welcome to Pengu-BlackJack!");
        System.out.println("(1) Start a game or (2) exit");


        int input = readInt();
        while (true) {

            if (input == 1) {
                while (true) {
                    System.out.println("Your current balance: " + tokens);
                    System.out.println("How much do you want to bet?");
                    int betInput = readInt();
                    while (true) {
                        if (betInput > 0 && betInput <= tokens) {
                            break;
                        }
                        System.out.println("How much do you want to bet?");
                        betInput = readInt();
                    }
                    int sum = 0;
                    System.out.println("Player cards:");
                    int card = deck.drawCard();
                    sum += card;
                    int number = 0;
                    System.out.println(++number + " : " + card);
                    card = deck.drawCard();
                    sum += card;
                    System.out.println(++number + " : " + card);

                    System.out.println("Current standing: " + sum);

					// edge case if betinput is less than cards sum

					if ( sum>betInput ) {
						System.out.println("Sorry, you are broke. Better Luck next time.");
						input = 2;
						break;


					}

                    // To check the 3rd card condition (sum)
                    while (sum < 21) {
                        System.out.println("(1) draw another card or (2) stay");
                        int cardInput = readInt();
                        if (cardInput == 1) {
                            card = deck.drawCard();
                            sum += card;
                            System.out.println(++number + " : " + card);
                            System.out.println("Current standing: " + sum);


                        } else if (cardInput == 2) {

                            // Dealer
                            System.out.println("Dealer cards:");
                            int dealerCardNumber = 0;
                            int dealerCardsSum = 0;

                            while (true) {
                                int dealerCard = deck.drawCard();
                                System.out.println(++dealerCardNumber + " : " + dealerCard);
                                dealerCardsSum += dealerCard;
                                if (dealerCardsSum > 21 || dealerCardsSum > sum) {
                                    break;
                                }
                            }

                            System.out.println("Dealer: " + dealerCardsSum);

                            if (dealerCardsSum > 21) {
                                tokens = tokens + betInput;
                                System.out.println("You won " + betInput + " tokens.");


                                System.out.println("(1) Start a game or (2) exit");
                                input = readInt();

                            } else {
                                tokens = tokens - betInput;
                                System.out.println("Dealer wins. You lost " + betInput + " tokens.");

                                System.out.println("(1) Start a game or (2) exit");

                                input = readInt();

                            }

                            break;

                        } else {
                            System.out.println("What?!");

                        }


                    }
                    if (sum > 21) {
                       // System.out.println("Current standing: " + sum);
                        System.out.println("You lost " + betInput  + " tokens.");
                        tokens=tokens-betInput;
                        System.out.println("(1) Start a game or (2) exit");
                        input = readInt();
                        break;


                    }
                    if (sum == 21) {
                       // System.out.println("Current standing: " + sum);
                        System.out.println("Blackjack! You won 840 tokens.");
                        tokens = tokens + 840;
                        System.out.println("(1) Start a game or (2) exit");
                        input = readInt();
                        break;

                    }
                    if (tokens <= 0 || sum>betInput ) {
                        System.out.println("Sorry, you are broke. Better Luck next time.");
                        input = 2;


                    }

                }
            } else if (input == 2) {
                System.out.println("Your final balance: " + tokens);
                if (tokens <= 1000) {
                    System.out.println("That's very very sad :(");
                } else {
                    System.out.println("Wohooo! Ez profit! :D");
                }
                System.out.println("Thank you for playing. See you next time.");
                break;

            } else {
                System.out.println("What?!");
                System.out.println("(1) Start a game or (2) exit");
                input = readInt();
            }
        }

        // TODO
    }

    public static String readString() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int readInt() {
        while (true) {
            String input = readString();
            try {
                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("This was not a valid number, please try again.");
            }
        }
    }

    public static void main(String[] args) {
        penguBlackJack();
    }

}
