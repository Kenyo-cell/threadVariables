public class Main {

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        Thread user = new User(game);

        user.start();
        game.start();

        user.join();
        game.setEnd(true);
    }
}
