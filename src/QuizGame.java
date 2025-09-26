import java.util.Scanner;

public class QuizGame{

    public static void main (String[] args){

        // 01 Java Quiz Game

        // Questions is an array of strings - a one dimensional array.
        String[] questions =    {"What is the main function of a router?",
                "Which part of the computer is considered the brain?",
                "What year was Facebook launched?",
                "Who is known as the father of computers?",
                "What was the first programming language?"};

        // We'll create a 2D array of options
        // 5 questions - so we'll need 5 arrays. one array for each question
        // Our first array within our 2D array of options will hold all of the options for our first question. Each value within this first array is going to be strings.
        String [][] options = { {"1. Storing Files", "2. Encrpyting Data", "3. Directing internet traffic", "4. Managing passwords"}, // all the different possible answers but only one will be correct
                {"1. CPU", "2. Hard Drive", "3. RAM", "4. GPU"}, // All the options for each question in questions
                {"1. 2001", "2. 2004", "3. 1999", "4. 2008"},
                {"1. Steve Jobs", "2. Bill Gates", "3. Alan Turing", "4. Charles Babbage"},
                {"1. COBOL", "2. C", "3. Fortran", "4. Assembly"}};

        // Create a 1D array for the correct answers. We'll need a key
        // list the correct answers as integers.
        int[] answers = {3, 1, 2, 4, 3};
        int score = 0;
        int guess; // whatever the user types in

        Scanner scanner = new Scanner(System.in);
        System.out.println("******************************");
        System.out.println("Welcome to the Java Quiz Game!");
        System.out.println("******************************");

        // for loop to list questions
        for(int i = 0; i < questions.length; i++){
            System.out.println(questions[i]);

            // after each question we have to list all the different options - display question and then create a nested loop to display all of the options
            // what is the data type of each value within each array (within array) - Working with strings
            for(String option : options[i]){ // display every option in each inner array
                System.out.println(option);

            }

            // user will type in a number 1-4
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();

            // check our guess
            if(guess == answers[i]){
                System.out.println("*********");
                System.out.println("CORRECT! 👍");
                System.out.println("*********");
                // display final score - after we get the correct answer increment our score by one
                score++;
            }
            else{
                System.out.println("*********");
                System.out.println("WRONG!🥺");
                System.out.println("*********");
            }
        }

        System.out.println("Your final score is: " + score + " out of " + questions.length);

        scanner.close();
    }
}

