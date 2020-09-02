package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {
	public double x, y;
	public final int width, height;
	
	public double dx, dy, ex, ey;
	public double speed = 1.6;
	
	public Ball(double x, double y) {
		this.x = x;
		this.y = y;
		width = 5;
		height = 5;
		
		bounce();
}
	
	public void tick() {
		if((x + ex + width > Game.WIDTH) || (x + ex < 0.0)) {
			dx *= -1.0;
		}
		
		if(y >= Game.HEIGHT) {
			System.out.println("ENEMY SCORE +1");
			new Game();
			return;
		} else if(y < 0.0) {
			System.out.println("PLAYER SCORE +1");
			new Game();
			return;
		}
		
		Rectangle bounds = new Rectangle((int) (x + ex), (int) (y + ey), width, height);
		Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.width, Game.player.height);
		Rectangle boundsEnemy = new Rectangle((int) Game.enemy.x, (int) Game.enemy.y, Game.enemy.width, Game.enemy.height);
		
		if(bounds.intersects(boundsPlayer)) {
			bounce();
			if(dy > 0)
				dy *= -1.0;
		} else if(bounds.intersects(boundsEnemy)) {
			bounce();
			if(dy < 0)
				dy *= -1.0;
		}

		ex = dx * speed;
		ey = dy * speed;

		x += ex;
		y += ey;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect((int) x, (int) y, width, height);
	}
	
	public void bounce() {
		int angle = new Random().nextInt(75) + 45;
		dx = Math.cos(Math.toRadians(angle));
		dy = Math.sin(Math.toRadians(angle));
	}
}
