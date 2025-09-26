import java.util.Random;
import java.util.Scanner;

public class slotMachine {

    public static void main(String[] args){

        // Program: Slot Machine

        Scanner scanner = new Scanner(System.in); // accepting user input so Scanner is needed

        // declare variables
        int balance = 100;
        int amountBet;
        int payOut;         // winnings
        String[] row;        // contain symbols
        String playAgain;

        // Welcome message
        System.out.println("〰️️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️️️〰️");
        System.out.println(" Welcome to Juicy Jackpot Slots! 🎰 ");
        System.out.println("Lucky Symbols: 🍇 🍉 🍒 ‍🥝 🥕‍");
        System.out.println("〰️️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️️️〰️");


        // play if money balance is > 0. while our balance is > 0 continue playing
        while(balance > 0){
            // display current balance and prompt user to enter be amount
            System.out.println("Your current balance is: $" + balance);
            System.out.print("Enter your bet amount: ");
            amountBet = scanner.nextInt();
            scanner.nextLine();         // to get rid of that new line character (input buffer)

            // verify if bet is greater than balance and greater than 0
            if(amountBet > balance){
                System.out.println("INSUFFICIENT FUNDS ⛔");
                continue; // to skip the current cycle of this loop and go back to the beginning
            }
            else if(amountBet <= 0){
                System.out.println("Stop.✋ Bet must be greater than 0");
                continue;
            }
            else{
                balance -= amountBet;       // balance = balance - amountBet
            }

            System.out.println("Spinning......");
            row = spinRow();                     // call method to spin our row. will return a string array which we're assigning to row
            printRow(row);
            payOut = getPayout(row, amountBet);                        // call method to get our payout (winnings)

            if(payOut > 0){     // we won something
                System.out.println("You won $" + payOut);
                balance += payOut;
            }
            else{
                System.out.println("Sorry you lost this round! ");
            }

            // Prompt user to play again
            System.out.print("Do you want to play again? (Y/N): ");
            playAgain = scanner.nextLine().toUpperCase();

            if(!playAgain.equals("Y")){
                break;
            }


        }

        // Exit message
        System.out.println("GAME OVER! 🎰");
        System.out.println("Your final balance is $" + balance);

        scanner.close();
    }

    static String[] spinRow(){

        String[] symbols = {"🍇", "🍉", "🍒" ,"🥝", "🥕"};
        String[] row = new String[3];                // row will be empty and a new string array that can hold three elements (three strings) which will be picked at random.
        Random random = new Random();

        // Generate three random symbols
        for(int i = 0; i < 3; i++){
            row[i] = symbols[random.nextInt(symbols.length)];       // picking a random symbol from our array of strings (array of emojis)
        }

        return row;
    }
    static void printRow(String[] row){
        System.out.println("**************");
        System.out.println(" " + String.join(" | ", row)); // for each character in a string we can join them together with another character
        System.out.println("**************");
    }
    static int getPayout(String[] row, int amountBet){
        // check to see if we have any messages
        // check if all 3 symbols match
        if(row[0].equals(row[1]) && row[1].equals(row[2])){
            return switch (row[0]){
                case "🍇" -> amountBet * 2;      // we get a payout of 3 * what we bet
                case "🍉" -> amountBet * 4;
                case "🍒" -> amountBet * 5;
                case "🥝" -> amountBet * 10;
                case "🥕" -> amountBet * 20;
                default -> 0;                    // no matches
            };
        }
        // Only checking the first two symbols - if they match
        else if(row[0].equals(row[1])){
            return switch (row[0]){
                case "🍇" -> amountBet * 2;
                case "🍉" -> amountBet * 3;
                case "🍒" -> amountBet * 4;
                case "🥝" -> amountBet * 5;
                case "🥕" -> amountBet * 10;
                default -> 0;
            };
        }

        else if(row[1].equals(row[2])){
            return switch (row[1]){
                case "🍇" -> amountBet * 2;
                case "🍉" -> amountBet * 3;
                case "🍒" -> amountBet * 4;
                case "🥝" -> amountBet * 5;
                case "🥕" -> amountBet * 10;
                default -> 0;
            };
        }

        return 0;
    }
}
