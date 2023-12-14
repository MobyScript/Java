import java.util.Scanner;

public class Clock {

    private int time;
    private boolean End = false;

    Scanner UserInput = new Scanner(System.in);

    public void Start() {
        System.out.println("=====================================");
        System.out.println("Welcome to the StopWatch");
        System.out.println("To interact with the StopWatch");
        System.out.println("=====================================");

        while (End == false) {

            System.out.println("To Stop: Stop");
            System.out.println("To Time: Time");

            // Variables
            String userAction = UserInput.next();
            String userActionLower = userAction.toLowerCase();
            // CompletableFuture<Long> completableFuture = CompletableFuture;

            if (userActionLower.equals("stop")) {
                Stop();
            } else if (userActionLower.equals("time")) {
                getTime();
            } else {
                System.out.println("Invalid Input");
            }
        }

    }

    void getTime() {
        System.out.println("Time is: " + this.time);

    }

    void Stop() {

        System.out.println("Clock is stopped");
        System.out.println("Total Time: " + this.time);
        End = true;

    }
}
