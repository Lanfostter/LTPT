public class Dekker implements Lock {
    public Lock myLock;
    int turn = 1;
    int N = 2;
    boolean[] wantCS = {false, true};

    @Override
    public void requestCS(int tid) {
        int j = 1 - tid;
        wantCS[tid] = true;
        while (wantCS[j]) {
            if (turn == j) {
                wantCS[tid] = false;
                while (turn == j) {
                    wantCS[tid] = true;
                }
            }
        }

    }

    @Override
    public void releaseCS(int tid) {
        turn = 1 - tid;
        wantCS[tid] = false;
    }

}
