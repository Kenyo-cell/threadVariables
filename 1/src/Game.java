import java.util.concurrent.atomic.AtomicBoolean;

public class Game extends Thread {
    private AtomicBoolean flag;
    private boolean isEnd = false;

    public Game() {
        setName("Game");
        flag = new AtomicBoolean(false);
    }

    public void userChange() {
        this.flag.compareAndSet(false, true);
        System.out.printf("%s changed flag to %b\n", Thread.currentThread().getName(), flag.get());
    }


    public void setEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    @Override
    public void run() {
        while (!isEnd) {
            if (flag.get() == true) {
                flag.compareAndSet(true, false);
                System.out.printf("%s changed flag to %b\n", getName(), flag.get());
            }
        }
    }
}
