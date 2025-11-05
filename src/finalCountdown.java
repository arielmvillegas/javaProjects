import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class finalCountdown {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.println("------------------------------------");
        System.out.println("Welcome to The Final Countdown! ⏰  ");
        System.out.println("------------------------------------");
        System.out.print("Enter the number of seconds to countdown from: ");
        int response = scanner.nextInt();

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {          // for a one time use you can override the run method for our timertask object bc we only plan on using it once, so we can write an anonymous class

            int count = response;

            @Override
            public void run() {
                // when our timer executes our task what would we like to do

                System.out.println(count);
                count--;
                // escape the run method
                if(count <= 0){
                    System.out.println("HAPPY NEW YEAR! 🎊🥳");
                    timer.cancel(); // stop our timer
                }
            }
        };

        // set up our timer
        timer.scheduleAtFixedRate(task, 0, 1000);         // 3 arguments we need to pass in (task, delay, period)

    }
}

