// import class for file
import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class musicPlayer {
    public static void main(String[] args){
        // Play Audio with Java

        // string for our filePath (relative file path)
        String filePath = "src\\Boogie Down - The Grey Room _ Golden Palms.wav";

        // create a file object, pass in our filePath as an argument to create a file object
        File file = new File(filePath);

        // create an audio input string object
        try(Scanner scanner = new Scanner(System.in);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)){

            // clip object = clip like a music or sound player, it allows you to load an audio file then play pause or reset the audio.
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);     // clip object which is our player is going to open our audioStream

            String response = "";

            while(!response.equals("Q")){   // as long as it's not Q we'll continue the program
                System.out.println("----- Audio Options 🎼 -----");
                System.out.println("P = Play the song ▶️");
                System.out.println("S = Stop the song 🖐️");
                System.out.println("R = Replay the song 🔄️");
                System.out.println("Q =  Quit the song 🛑");
                System.out.print("Enter your choice: ");

                response = scanner.next().toUpperCase();

                // give the user a few options
                // don't want audio to begin until user enters P to play
                switch (response){
                    case "P" -> clip.start();
                    case "S" -> clip.stop();
                    case "R" -> clip.setMicrosecondPosition(0);
                    case "Q" -> clip.close();
                    // if no mathcing cases output the following
                    default -> System.out.println("Invalid choice. Try again");
                }

            }

        }
        catch(FileNotFoundException e){    // catch any file not found exceptions if we can't locate our audio file
            System.out.println("Could not locate file");
        }
        catch(LineUnavailableException e){  // if it's unplayable or unavailable
            System.out.println("Unable to access audio resources");

        }
        catch(UnsupportedAudioFileException e){
            System.out.println("Audio file is not supported");
        }
        // safety net
        catch(IOException e){
            System.out.println("Something went wrong");
        }
        finally {
            System.out.println("Goodbye! I hope you enjoyed some good tunes. 🙂‍↕️🎶");
        }
    }
}
