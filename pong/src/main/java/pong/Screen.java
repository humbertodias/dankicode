package pong;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Screen extends Canvas {

  public static JFrame jframe;
  public static Canvas canvas;
  private String jframeTitle;
  private int WIDTH;
  private int HEIGHT;
  private int SCALE;

  public Screen(String jframeTitle, int WIDTH, int HEIGHT, int SCALE) {
    this.WIDTH = WIDTH;
    this.HEIGHT = HEIGHT;
    this.SCALE = SCALE;

    this.canvas = new Canvas();
    this.canvas.setPreferredSize(new Dimension(this.WIDTH * this.SCALE, this.HEIGHT * this.SCALE));

    this.jframeTitle = jframeTitle;
    this.jframe = new JFrame(this.jframeTitle);
    this.jframe.setPreferredSize(new Dimension(this.WIDTH * this.SCALE, this.HEIGHT * this.SCALE));

    this.jframe.add(this.canvas);
    this.jframe.setResizable(false);
    this.jframe.pack();
    this.jframe.setLocationRelativeTo(null);
    this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void showScreen() {
    this.jframe.setVisible(true);
  }

  public void drawBackground(Graphics g) {
    g.fillRect(0, 0, this.WIDTH * this.SCALE, this.HEIGHT * this.SCALE);
  }

  public void drawScore(Graphics g, int enemyScore, int playerScore) {
    g.fillRect(0, this.SCALE * ((this.HEIGHT / 2) - 2), this.WIDTH * this.SCALE, 2);
    g.drawString("" + enemyScore, this.SCALE * (this.WIDTH / 2), this.SCALE * (this.HEIGHT / 4));
    g.drawString(
        "" + playerScore, this.SCALE * (this.WIDTH / 2), this.SCALE * (3 * this.HEIGHT / 4));
  }
}
