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

    private boolean isPrime(int n) {
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
    
    public B1(ArrayList<Integer> arr_i) {
        mangb = new ArrayList<>();
        mangb.addAll(arr_i);
    }

    public int getCount() {
        return count;
    }
}
