import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;

public class Main {

    private static volatile int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        final FileWriter[] writer = {null};

        try {
            writer[0] = new FileWriter("output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread t1 = new Thread(() -> {
            while (counter < 240) {
                try {
                    Thread.sleep(250);
                    writer[0].write(String.format("Thread 1, %s, %d\n", LocalTime.now(), counter));
                    counter++;
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (counter < 240) {
                try {
                    Thread.sleep(500);
                    writer[0].write(String.format("Thread 2, %s, %d\n", LocalTime.now(), counter));
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(() -> {
            while (counter < 240) {
                try {
                    Thread.sleep(1000);
                    writer[0].write(String.format("Thread 3, %s, %d\n", LocalTime.now(), counter));
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        try {
            writer[0].close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
