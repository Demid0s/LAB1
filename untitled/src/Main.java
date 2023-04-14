import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] first = new int[10000];
        int[] second = new int[10000];
        int[] result = new int[10000];

        // заповнення масивів довільними значеннями
        for (int i = 0; i < 10000; i++) {
            first[i] = (int) (Math.random() * 100 + 1 );
            second[i] = (int) (Math.random() * 100 + 1 );
        }
        long time1 = System.currentTimeMillis();
        int sleep=1;
        // Якщо зрівнювати з традиційним методом (цикл)  то thread.sleep зі зміною sleep =1    у данному випадку не має жодної ваги
      
        Arrays.stream(first).parallel().forEach(i -> {result[i] = first[i] * second[i];
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
                });



        System.out.println("Result: " + Arrays.toString(result));
        System.out.printf("sync : %s\n", System.currentTimeMillis() - time1);
    }
}
