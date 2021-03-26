import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class Main {

    public static LongAdder adder = new LongAdder();
    private static Random random = new Random();
    private static final int MAX_LONGS = 1000;
    private static final int MAX_VALUE = 100_000;

    private static List<Long> generateList() {
        List<Long> longList = new LinkedList<>();
        for (int i = 0; i < random.nextInt(MAX_LONGS); i++) {
            longList.add(Long.valueOf(random.nextInt(MAX_VALUE)));
        }return longList;
    }

    private static List<Long> fixedList() {
        List<Long> longList = new LinkedList<>();
        for (int i = 1; i <= MAX_LONGS; i++) {
            longList.add(Long.valueOf(i));
        }
        return longList;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Shop(fixedList()));
        Thread t2 = new Thread(new Shop(fixedList()));
        Thread t3 = new Thread(new Shop(fixedList()));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(adder.sum());

        adder.reset();

        t1 = new Thread(new Shop(generateList()));
        t2 = new Thread(new Shop(generateList()));
        t3 = new Thread(new Shop(generateList()));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(adder.sum());
    }
}
