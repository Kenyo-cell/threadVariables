import java.util.List;

public class Shop implements Runnable {

    private List<Long> list;

    public Shop(List<Long> list) {
        this.list = list;
    }

    @Override
    public void run() {
        long sum = list.stream().mapToLong(Long::longValue).sum();
        System.out.println(sum);
        Main.adder.add(sum);
    }
}
