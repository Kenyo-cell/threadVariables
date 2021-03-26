public class User extends Thread {
    private final int FREQUENCY = 2500;
    private final int COUNT = 5;
    private final Game game;

    public User(Game game) {
        setName("User");
        this.game = game;
    }

    @Override
    public void run() {
        for (int i = 0; i < COUNT; i++) {
            try {
                Thread.sleep(FREQUENCY);
            } catch (InterruptedException e) { }
            game.userChange();
        }
        System.out.printf("%s done\n", getName());
    }
}
