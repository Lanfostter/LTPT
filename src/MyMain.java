import java.lang.reflect.Method;

public class MyMain {
    static int counter = 0;

    public static void main(String[] args) throws InterruptedException, NoSuchMethodException, SecurityException {
        MyThread tA;
        MyThread tB;
        Class[] parameterTypes = new Class[2];
        parameterTypes[0] = Void.class;
        parameterTypes[1] = Void.class;
        Method func1 = MyMain.class.getMethod("increament", parameterTypes[0]);
        Method func2= MyMain.class.getMethod("decreament", parameterTypes[1]);
        tA = new MyThread(func1);
        tA.start();
        tB = new MyThread(func2);
        tB.start();
        tA.join();
        tB.join();
        System.out.println(counter);
    }

    void incrementer() {
        for (int i = 0; i < 50; i++) {
            counter += 2;
        }
    }

    void decrementer() {
        for (int i = 0; i < 50; i++) {
            counter -= 2;
        }
    }
}
