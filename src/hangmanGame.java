import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class hangmanGame {
    public static void main (String[] args){

        String filePath = "src\\words.txt";
        ArrayList<String> words = new ArrayList<>();

        // read this file
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;            // local variable
            while((line = reader.readLine()) != null){
                // assign them to our ArrayList of words
                words.add(line.trim());
            }

        }
        catch(FileNotFoundException e){
            System.out.println("Could not find file");
        }
        // safety net
        catch(IOException e){
            System.out.println("Something went wrong");
        }

        // choose a word at random
        Random random = new Random();
        String word = words.get(random.nextInt(words.size()));

        Scanner scanner = new Scanner(System.in);
        // create an arrayList of characters - specify the type within the set of angle brackets
        // can't store primitives (char) so use the wrapper class of character to store characters
        ArrayList<Character> wordState = new ArrayList<>();
        int wrongGuesses = 0;

        // within our array of wordState we're going to add an underscore for every letter within our word.
        // for loop to cycle once for every letter in our word
        for(int i = 0; i < word.length(); i++){
            wordState.add('_'); // pass in '' single quotes not "double quotes" bc these are chars not strings
        }

        // welcome message
        System.out.println("-------------------------------------------");
        System.out.println("Welcome to Java Hangman: Test Your Wits! 🪂");
        System.out.println("-------------------------------------------");


        // going to continue playing as long as wrongGuesses is less than 6. Once wrongGuesses is 6 or greater than the game ends.
        while(wrongGuesses < 6){

            // display ascii art
            System.out.print(getHangmanArt(wrongGuesses));



            System.out.print("Guess the word: ");

            for(char c : wordState){
                System.out.print(c + " ");
            }
            System.out.println();       // empty print line, so we go down the next line.

            // have the user guess a letter (user input)
            System.out.print("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);       // next will get the next character

            // check if our guess matches any letters within our word
            if(word.indexOf(guess) >= 0){
                System.out.println("Correct guess!");

                // if correct guess change wordState bc that's one less letter the user needs to guess - cycle through the length of our world
                for(int i = 0; i < word.length(); i++){
                    // need to see where there's a match exactly. what index within our word?
                    if(word.charAt(i) == guess){
                        wordState.set(i,guess);
                    }
                }

                // winner
                if(!wordState.contains('_')){           // if our wordStates doesn't contain anymore _ then that means we guessed all the letters
                    System.out.println(getHangmanArt(wrongGuesses));
                    System.out.println("YOU WIN!!");
                    System.out.println("The word was: " + word);
                    break;          // to break out of the loop
                }
            }
            else{
                wrongGuesses++;
                System.out.println("Wrong guess!");
            }
        }

        // if you loose
        if(wrongGuesses >= 6){
            System.out.print(getHangmanArt(wrongGuesses));
            System.out.println("GAME OVER!");
            System.out.println("The word was: " + word);
        }


        scanner.close();

    }

    // declare another method that is in charge of returning ascii art based on the number of wrong guesses we have
    // add one parameter - pass in how many wrongGuesses we have and depending on that we'll return a certain image
    static String getHangmanArt(int wrongGuesses){

        // switch can return something - within our swtich wer're examining the amount of wrongGuesses and will need a case for each of those guesses.
        // depending how many wrong guesses the user has we'll display one of the few images
        return switch(wrongGuesses){
            case 0 -> """
                      
                      
                      """;                       // no wrong guesses

            case 1 -> """                       
                        o
                      
                      """;

            case 2 -> """                       
                        o
                        |
                        
                      """;

            case 3 -> """                       
                        o
                       /|
                      
                      """;

            case 4 -> """                       
                        o
                       /|\\
         
                      """;

            case 5 -> """                       
                        o
                       /|\\
                       /
                      """;

            case 6 -> """                       
                        o
                       /|\\
                       / \\
                      """;

            default -> "";          // if there's no matching cases return an empty string
        };
    }
}
