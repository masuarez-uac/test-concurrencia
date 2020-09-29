import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BigInteger result[] = new BigInteger[2];
        long startTime = System.currentTimeMillis();
        for (int n = 100; n <= 1000; n+=100) {
            Thread t1 = new Thread(new ThreadFactorial(1, n / 2, result, 0));
            Thread t2 = new Thread(new ThreadFactorial(n / 2 + 1, n, result, 1));

            t1.start();
            t2.start();

            t1.join();
            t2.join();

            BigInteger factorial = result[0].multiply(result[1]);
            long endTime = System.currentTimeMillis();
            //System.out.println("El resultado es " + factorial);
            long elapsedTime = endTime - startTime;
            //System.out.println("El tiempo transcurrido fué de " + (double) elapsedTime / 1000 + " segundos");
            System.out.println(n + "\t" + (double)elapsedTime/1000);
        }
    }
}
