import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class B1main {
    private static boolean isPrime(int n) {
        // so nguyen n < 2 khong phai la so nguyen to
        if (n < 2) {
            return false;
        }
        // check so nguyen to khi n >= 2
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, numberofthread, count;
        long start, end;
        System.out.println("Nhap N = ");
        n = sc.nextInt();
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
        end = System.currentTimeMillis();
        System.out.println("Da luong: " + (end - start));
        System.out.println("------------------");
        // single thread
        start = System.currentTimeMillis();
        count = 0;
        //  count element number from array
        for (Integer in : mang) {
            if (isPrime(in))
                count++;
            // System.out.println("Don luong " + in);
        }
        System.out.println("Tong so nguyen to khi chay don luong la " + count);
        end = System.currentTimeMillis();
        System.out.println("Don luong: " + (end - start));
    }
}
