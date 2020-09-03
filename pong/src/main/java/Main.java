import pong.Game;

public class Main {

  public static int WIDTH = 250;
  public static int HEIGHT = 250;
  public static int SCALE = 1;

  public static String TITLE = "Pong Player";

  public static void main(String[] args) {

    Game game = new Game(TITLE, WIDTH, HEIGHT, SCALE);

    game.startGame();
  }
}
