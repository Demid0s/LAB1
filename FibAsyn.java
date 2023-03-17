import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FibAsyn {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть n: ");
        int n = scanner.nextInt();

        CompletableFuture<Integer> Result = CompletableFuture.supplyAsync(() -> fibonacci(n));

        // Виводимо повідомлення про очікування результату
        System.out.println("Очікуємо результату обчислень...");

        // Очікуємо завершення обчислень та виводимо результат Вводимо наприклад  45 и бачимо що спочатку очікування а через деякий щас виводе результат
        int result = Result.get();
        System.out.println("n-те число Фібоначчі: " + result);
    }


    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}
