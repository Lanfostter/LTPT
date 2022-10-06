import java.lang.reflect.Method;

public class MyThread extends Thread {
    Dekker dekker;
    int tid;

    public MyThread(Method func){

    }
    public MyThread(){
        
    }

    void CS() {

    }

    void nonCS() {

    }

    @Override
    public void run() {
        while (true) {
            dekker.requestCS(tid);
            CS();
            dekker.releaseCS(tid);
            nonCS();
        }
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

   
}
