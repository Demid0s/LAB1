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
            extracted(writer,250);
        });
        Thread t2 = new Thread(() -> {
            extracted(writer,500);
        });
        Thread t3 = new Thread(() -> {
            extracted(writer,1000);
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


    private static void extracted(FileWriter[] writer,int n) {
        int thread_num=0;
        int sleep=0;

        while (counter < 240) {
            try {
                if(n==250){
                    sleep=250;
                    thread_num=1;
                    counter++;
                }
                if(n==500){
                    sleep=500;
                    thread_num=2;
                }
                if(n==1000){
                    sleep=1000;
                    thread_num=3;
                }
                Thread.sleep(sleep);
                writer[0].write(String.format("Thread %d, %s, %d\n",thread_num, LocalTime.now(), counter));

            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}