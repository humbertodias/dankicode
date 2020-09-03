package com.HLF.entities;

import com.HLF.main.Game;
import com.HLF.world.AStar;
import com.HLF.world.Vector2i;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy extends Entity {

  public boolean vulnerable = false;
  public int vulFrames = 0;

  public Enemy(int x, int y, int width, int height, int speed, BufferedImage sprite) {
    super(x, y, width, height, speed, sprite);
  }

  public void tick() {
    depth = 0;

    if (vulnerable == false) {

      if (path == null || path.size() == 0) {
        Vector2i start = new Vector2i(((int) (x / 16)), ((int) (y / 16)));
        Vector2i end = new Vector2i(((int) (Game.player.x / 16)), ((int) (Game.player.y / 16)));
        path = AStar.findPath(Game.world, start, end);
      }

      followPath(path);

      if (x % 16 == 0 && y % 16 == 0) {
        if (new Random().nextInt(100) < 90) {
          Vector2i start = new Vector2i(((int) (x / 16)), ((int) (y / 16)));
          Vector2i end = new Vector2i(((int) (Game.player.x / 16)), ((int) (Game.player.y / 16)));
          path = AStar.findPath(Game.world, start, end);
        }
      }
    }

    // TODO vulnerable mode after eating something
  }

  public void render(Graphics g) {
    super.render(g);
  }
}
