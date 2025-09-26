import java.util.Random;
import java.util.Scanner;

public class rockPaperScissors {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random(); // generate random numbers

        String[] choices = {"rock", "paper", "scissors"};
        String playerChoice;
        String computerChoice;
        String playAgain = "yes"; // while playAgain == yes play again.


        do {
            // Prompt the user
            System.out.print("Enter your move (rock 🪨, paper 📃, scissors ✂️): ");
            playerChoice = scanner.nextLine().toLowerCase(); // in case a user types in Rock, Paper, or Scissors

            // determine if user input is valid - linking three conditions together.
            // if doesn't equal rock and paper and playerchoice doesn't equal scissors.
            if (!playerChoice.equals("rock") &&
                    !playerChoice.equals("paper") &&
                    !playerChoice.equals("scissors")) {
                System.out.println("Invalid Choice\n");
                continue;
            }

            // method of a random object will return a random number between 0 and 2.
            // 0 - rock, 1 - paper, 2 - scissors
            computerChoice = choices[random.nextInt(3)];
            System.out.println("Computer Choice: " + computerChoice);


            // Condition check (winning possibilities. A draw, won, or lost)
            if (playerChoice.equals(computerChoice)) {
                System.out.println("It's a tie!! 🤝\n");
            }
            // list all the different win conditions
            else if ((playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                    ((playerChoice.equals("paper") && computerChoice.equals("rock"))) ||
                    ((playerChoice.equals("scissors") && computerChoice.equals("paper")))){
                System.out.println("Yay, you win!! 🎊\n");
            }
            else{
                System.out.println("Better luck next time. You lose! ☹️\n");

            }

            // Play again?
            System.out.println("Would you like to play again? 🎮");
            System.out.print("Yes/No:");
            playAgain = scanner.nextLine().toLowerCase();

        }while (playAgain.equals("yes"));

        // goodbye message
        System.out.println("Thanks for playing! 👋🕹️");

        scanner.close();
    }

}
