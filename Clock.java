import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Clock {

    private int time;
    private boolean End = false;
    private boolean Start = false;

    Scanner UserInput = new Scanner(System.in);

    public void Start() {
        gameMessage();
        // new CountDownLatch(time)

        while (!End) {
            String actionStart = UserInput.next();
            String actionStartLower = actionStart.toLowerCase();
            if (actionStartLower.equals("start")) {
                Start = true;
                if (Start) {
                    while (End == false) {
                        runGame();
                        runClock();
                        // sleep run clock
                        if (actionStartLower.equals("pause")) {

                        }
                    }
                }
            } else {
                System.out.println("Invalid Input");
            }
        }

    }

    // Methods
    void gameMessage() {
        System.out.println("=====================================");
        System.out.println("Welcome to the StopWatch");
        System.out.println("To interact with the StopWatch");
        System.out.println("Type Start");
        System.out.println("=====================================");
    }

    void runGame() {
        System.out.println("To Stop: Stop");
        System.out.println("To Time: Time");
        String userAction = UserInput.next();
        String userActionLower = userAction.toLowerCase();

        if (userActionLower.equals("stop")) {
            Stop();
        } else if (userActionLower.equals("time")) {
            getTime();
        } else {
            System.out.println("Invalid Input");
        }
    }

    CompletableFuture<Void> runClock() {
        System.out.println("Clock is started");

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            while (!End) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    time++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        return future;

    }

    void Stop() {

        System.out.println("Clock is stopped");
        System.out.println("Total Time: " + this.time);
        End = true;

    }

    void setLap() {

        // this.time

    }

    void getLap() {
        System.out.println("Lap is: " + time);
    }

    void getTime() {
        System.out.println("Time is: " + time);
    }

}
