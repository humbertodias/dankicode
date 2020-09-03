package pong;

public class Player extends PongPlayer {

  public Player(int SCREEN_WIDTH, int SCREEN_HEIGHT, int SCALE) {
    this.SCREEN_WIDTH = SCREEN_WIDTH * SCALE;
    this.SCREEN_HEIGHT = SCREEN_HEIGHT * SCALE;
    this.SCALE = SCALE;

    int playerWidth = 50 * this.SCALE;
    int playerHeight = 5 * this.SCALE;
    int player_x = (int) (this.SCREEN_WIDTH / 2);
    int player_y = this.SCREEN_HEIGHT - playerHeight;

    this.setPongPlayerSize(playerWidth, playerHeight);
    this.setPongPlayerPosition(player_x, player_y);
  }
}
