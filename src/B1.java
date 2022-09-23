import java.util.ArrayList;

public class B1 extends Thread {
    private int count = 0;
    private ArrayList<Integer> mangb;

    @Override
    public void run() {
        for (Integer a : mangb) {
            if (isPrimeNumber(a)) {
                count++;
                // System.out.println(this.getName() + " " + a);
            }
        }
    }

    public static boolean isPrimeNumber(int n) {
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
    
    public B1(ArrayList<Integer> arr_i) {
        mangb = new ArrayList<>();
        mangb.addAll(arr_i);
    }

    public int getCount() {
        return count;
    }
}
