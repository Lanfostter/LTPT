import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class B1main {
    private static boolean isPrime(int n) {
        if (n <= 1)
            return false;
 
        else if (n == 2)
            return true;
 
        else if (n % 2 == 0)
            return false;
 
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, numberofthread, count;
        long start, end;
        System.out.println("Nhap N = ");
        n = sc.nextInt();
        if(n < 20){
            n = 21;
        }
        sc.nextLine();
        System.out.println("So luong ban muon nhap ");
        numberofthread = sc.nextInt();
        sc.nextLine();
        ArrayList<Integer> mang = new ArrayList<Integer>();
        ArrayList<B1> b1s = new ArrayList<B1>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            mang.add(random.nextInt());
        }
        // multiple threads
        start = System.currentTimeMillis();
        count = 0;
        for (int i = 0; i < numberofthread; i++) {
            b1s.add(new B1(new ArrayList<>(mang.subList(i * n / numberofthread, (i + 1) * n / numberofthread))));
            b1s.get(i).start();
        }
        for (B1 t : b1s) {
            try {
                // Mainthread will wait for other threads 
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(t.getName() + " - " + t.getCount());
            count += t.getCount();
        }
        System.out.println("------------------");
        System.out.println("Tong so nguyen to khi chay da luong la: " + count);
        System.out.println("------------------");
        end = System.currentTimeMillis();
        long multiplethread = 0;
        multiplethread = end - start;
        // single thread
        start = System.currentTimeMillis();
        count = 0;
        //  count prime number from array
        for (Integer in : mang) {
            if (isPrime(in)){
                count++;
            System.out.println("Don luong " + in);
            }
        }
        System.out.println("------------------");
        System.out.println("Tong so nguyen to khi chay don luong la " + count);
        end = System.currentTimeMillis();
        System.out.println("------------------");
        System.out.println("Da luong: " + multiplethread + " milliseconds ");
        long singlethread = 0;
        System.out.println("Don luong: " + (end - start) + " milliseconds ");
        singlethread = end - start;
        System.out.println("------------------");
        if(singlethread < multiplethread){
            System.out.println("Don luong chay nhanh hon da luong");
        }
        else{
            System.out.println("Da luong chay nhanh hon don luong");
        }
    }
}
